#!/usr/bin/env python3
"""One-shot migration tool: moves legacy provider-rooted Java files into
the java/src/main/java tree and applies per-provider content transforms.

Safe to delete after migration completes; kept in-tree as documentation
of how the layout was derived.
"""

import argparse
import re
import subprocess
import sys
from pathlib import Path

REPO = Path(__file__).resolve().parent.parent
JAVA_ROOT = REPO / 'java' / 'src' / 'main' / 'java'

# --- Path transforms -------------------------------------------------

ALGOEXPERT_TIER = {
    'easy': 'easy',
    'medium': 'medium',
    'hard': 'hard',
    'very-hard': 'veryhard',
}

CODESIGNAL_SECTION = {
    'intro': 'intro',
    'the-core': 'thecore',
}

SPECIAL_PROBLEM_RENAMES = {
    'isDigit': 'is_digit',
    'a*-algorithm': 'a_star_algorithm',
}


def kebab_to_snake(name: str) -> str:
    return name.replace('-', '_')


def problem_to_snake(name: str) -> str:
    return SPECIAL_PROBLEM_RENAMES.get(name, kebab_to_snake(name))


def normalize_solution_filename(fname: str) -> str | None:
    """Canonicalize a solution filename to `Solution{N}.java`.

    The legacy tree mixes four naming styles for the same artifact:
        Solution1.java, solution-1.java, solution1.java, solution4.java

    Returns the canonical form, or None if the filename does not match any
    known solution pattern (e.g. `Solution.java`, `README.md`).
    """
    m = re.fullmatch(r'(?:S|s)olution-?(\d+)\.java', fname)
    if not m:
        return None
    return f'Solution{m.group(1)}.java'


def new_path_for(src: Path) -> Path | None:
    """Map a legacy source path to its destination under JAVA_ROOT.

    Returns None if the file is outside any known provider root, has an
    unexpected depth, or carries a filename the migrator cannot canonicalize.
    """
    try:
        rel = src.relative_to(REPO)
    except ValueError:
        return None
    parts = rel.parts
    if not parts:
        return None
    if parts[0] == 'algoexpert.io':
        if len(parts) != 4:
            return None
        _, tier, problem, fname = parts
        mapped_tier = ALGOEXPERT_TIER.get(tier)
        if mapped_tier is None:
            return None
        canonical = normalize_solution_filename(fname)
        if canonical is None:
            return None
        return (JAVA_ROOT / 'algoexpert' / mapped_tier
                / problem_to_snake(problem) / canonical)
    if parts[0] == 'codesignal.com':
        if len(parts) != 4:
            return None
        _, section, problem, fname = parts
        mapped_section = CODESIGNAL_SECTION.get(section)
        if mapped_section is None:
            return None
        canonical = normalize_solution_filename(fname)
        if canonical is None:
            return None
        return (JAVA_ROOT / 'codesignal' / mapped_section
                / problem_to_snake(problem) / canonical)
    if parts[0] == 'educative.io':
        if len(parts) != 5:
            return None
        _, _, pattern, problem, fname = parts
        canonical = normalize_solution_filename(fname)
        if canonical is None:
            return None
        return (JAVA_ROOT / 'educative' / 'patterns'
                / problem_to_snake(pattern) / problem_to_snake(problem)
                / canonical)
    return None


def package_for(dest: Path) -> str:
    """Derive Java package name from a destination path under JAVA_ROOT."""
    rel = dest.relative_to(JAVA_ROOT)
    return '.'.join(rel.parts[:-1])


# --- README generation -----------------------------------------------

DIFFICULTY_DEFAULT = {
    ('algoexpert', 'easy'):     ('warm--up', 'green'),
    ('algoexpert', 'medium'):   ('medium', 'yellow'),
    ('algoexpert', 'hard'):     ('hard', 'orange'),
    ('algoexpert', 'veryhard'): ('very--hard', 'red'),
    ('codesignal', 'intro'):    ('warm--up', 'green'),
    ('codesignal', 'thecore'):  ('easy', 'yellowgreen'),
    ('educative', 'patterns'):  ('easy', 'yellowgreen'),
}

SOURCE_LABEL = {
    'algoexpert': 'AlgoExpert',
    'codesignal': 'CodeSignal',
    'educative':  'Educative',
}


def title_from_problem(problem_snake: str) -> str:
    return ' '.join(w.capitalize() for w in problem_snake.split('_'))


def readme_for(problem_dir: Path) -> str:
    """Render the per-problem README template."""
    rel = problem_dir.relative_to(JAVA_ROOT)
    provider = rel.parts[0]
    tier_key = rel.parts[1]
    problem_name = rel.parts[-1]
    title = title_from_problem(problem_name)
    difficulty, color = DIFFICULTY_DEFAULT[(provider, tier_key)]
    source = SOURCE_LABEL[provider]

    def _solution_index(name: str) -> int:
        m = re.search(r'\d+', name)
        return int(m.group()) if m else 0

    sol_files = sorted(
        (f.name for f in problem_dir.glob('Solution*.java')),
        key=_solution_index,
    )
    rows = '\n'.join(
        f'| {f.replace(".java", "")} | TODO | TODO | TODO |' for f in sol_files
    ) or '| Solution1 | TODO | TODO | TODO |'

    return (
        f'# {title}\n\n'
        f'![Difficulty](https://img.shields.io/badge/difficulty-{difficulty}-{color})\n'
        f'**Source:** {source}\n\n'
        '## 1. Problem\n\n'
        '<!-- TODO: paraphrase the problem in your own words. -->\n\n'
        '## 2. Solutions\n\n'
        '| File | Approach | Time | Space |\n'
        '|---|---|---|---|\n'
        f'{rows}\n'
    )


# --- Source file transforms ------------------------------------------

APPROACH_LINE = '// Approach: TODO.'


def solution_number(fname: str) -> int:
    m = re.fullmatch(r'Solution(\d+)\.java', fname)
    if not m:
        raise ValueError(f'unexpected filename: {fname}')
    return int(m.group(1))


def transform_algoexpert(content: str, package: str, sol_num: int) -> str:
    """AlgoExpert: prepend `package`, ensure `import java.util.*;`, rename
    whatever top-level class name the file currently has to Solution{N},
    and insert the Approach line above it.

    The original-tree class names are inconsistent: most use `class
    SolutionN`, but a substantial minority use `class Program`, mismatch
    the filename's number (e.g. `class Solution2` inside Solution3.java),
    or contain manual-edit corruption (`class ProgSolution2ram`). The
    rename normalizes all of these to the filename-derived `Solution{N}`.
    """
    return _transform_simple(content, package, sol_num)


def _transform_simple(content: str, package: str, sol_num: int) -> str:
    """Shared transform for AlgoExpert and Educative files.

    Both providers have files that already contain a class declaration
    (with varying names) and need: package prepended, java.util.* ensured,
    class renamed to Solution{N}, references to the old class name
    (e.g. `OldName.staticMethod(...)`) rewritten to the new name, and an
    Approach placeholder inserted.
    """
    imports, body = _split_imports(content)
    imports = _ensure_java_util_import(imports)
    body = body.rstrip() + '\n'

    new_class = f'Solution{sol_num}'
    m = re.search(r'^class ([A-Za-z_]\w*)\s*\{', body, flags=re.MULTILINE)
    if m:
        old_class = m.group(1)
        body = re.sub(
            r'^class ' + re.escape(old_class) + r'\s*\{',
            f'class {new_class} {{',
            body,
            count=1,
            flags=re.MULTILINE,
        )
        if old_class != new_class:
            body = re.sub(
                r'\b' + re.escape(old_class) + r'\b',
                new_class,
                body,
            )

    imports_block = '\n'.join(imports)
    return (
        f'package {package};\n'
        f'{imports_block}\n\n'
        f'{APPROACH_LINE}\n'
        f'{body}'
    )


def _split_imports(content: str) -> tuple[list[str], str]:
    """Strip leading import lines from content. Return (imports, rest).

    Blank lines between/after imports are dropped. The first non-blank,
    non-import line marks the start of `rest`.
    """
    lines = content.split('\n')
    imports: list[str] = []
    i = 0
    while i < len(lines):
        s = lines[i].strip()
        if s.startswith('import '):
            imports.append(lines[i])
            i += 1
        elif s == '':
            i += 1
            continue
        else:
            break
    rest = '\n'.join(lines[i:])
    return imports, rest


def _ensure_java_util_import(imports: list[str]) -> list[str]:
    if any('java.util.*' in imp for imp in imports):
        return imports
    return imports + ['import java.util.*;']


def _ensure_codesignal_imports(imports: list[str]) -> list[str]:
    """CodeSignal solutions are pasted into a web IDE that auto-imports
    common packages. To compile standalone, we ensure java.util, the
    stream package, and java.math are available — covers IntStream,
    Collectors, BigInteger uses that appear in a handful of solutions."""
    needed = [
        ('java.util.*', 'import java.util.*;'),
        ('java.util.stream.*', 'import java.util.stream.*;'),
        ('java.math.*', 'import java.math.*;'),
    ]
    result = list(imports)
    for marker, line in needed:
        if not any(marker in imp for imp in result):
            result.append(line)
    return result


def transform_codesignal(content: str, package: str, sol_num: int) -> str:
    """CodeSignal files come in two shapes:
       (a) bare function at top level: `int solution(...) { ... }`
       (b) already wrapped: `class Solution { int solution(...) {...} }`
    Some have imports; some have the class-name typo `SOlution`. The web
    IDE auto-imports the stream and math packages, so we add them here
    too — a few solutions reference IntStream and BigInteger directly."""
    imports, body = _split_imports(content)
    imports = _ensure_codesignal_imports(imports)
    body = body.rstrip() + '\n'

    has_class = bool(re.search(r'^class [A-Za-z_]\w*\s*\{', body, re.MULTILINE))
    if has_class:
        body = re.sub(
            r'^class [A-Za-z_]\w*\s*\{',
            f'class Solution{sol_num} {{',
            body,
            count=1,
            flags=re.MULTILINE,
        )
        body = re.sub(
            r'^(    )(?!static\b)(?!public\s+static\b)'
            r'((?:public\s+|private\s+|protected\s+)?'
            r'[A-Za-z_][\w\[\]<>]*\s+[A-Za-z_]\w*\s*\()',
            r'\1static \2',
            body,
            flags=re.MULTILINE,
        )
        new_body = body
    else:
        indented = '\n'.join(('    ' + ln) if ln else ln
                             for ln in body.rstrip('\n').split('\n'))
        indented = re.sub(
            r'^(    )(?!static\b)(?!public\s+static\b)'
            r'((?:public\s+|private\s+|protected\s+)?'
            r'[A-Za-z_][\w\[\]<>]*\s+[A-Za-z_]\w*\s*\()',
            r'\1static \2',
            indented,
            flags=re.MULTILINE,
        )
        new_body = f'class Solution{sol_num} {{\n{indented}\n}}\n'

    imports_block = '\n'.join(imports)
    return (
        f'package {package};\n'
        f'{imports_block}\n\n'
        f'{APPROACH_LINE}\n'
        f'{new_body}'
    )


def transform_educative(content: str, package: str, sol_num: int) -> str:
    """Educative: prepend package, ensure `import java.util.*;`, rename the
    problem-specific class to SolutionN, insert Approach line."""
    return _transform_simple(content, package, sol_num)


# --- Orchestrator ----------------------------------------------------

PROVIDER_ROOTS = {
    'algoexpert': 'algoexpert.io',
    'codesignal': 'codesignal.com',
    'educative':  'educative.io',
}


def _transform_for(provider: str, content: str, package: str, sol_num: int) -> str:
    if provider == 'algoexpert':
        return transform_algoexpert(content, package, sol_num)
    if provider == 'codesignal':
        return transform_codesignal(content, package, sol_num)
    if provider == 'educative':
        return transform_educative(content, package, sol_num)
    raise ValueError(f'unknown provider: {provider}')


def migrate_provider(provider: str, dry_run: bool = False) -> None:
    legacy_root = REPO / PROVIDER_ROOTS[provider]
    if not legacy_root.exists():
        print(f'no legacy directory for {provider} at {legacy_root}',
              file=sys.stderr)
        return

    java_files = sorted(legacy_root.rglob('*.java'))
    print(f'{provider}: {len(java_files)} file(s) to migrate')

    moves: list[tuple[Path, Path]] = []
    for src in java_files:
        dest = new_path_for(src)
        if dest is None:
            print(f'  SKIP (no mapping): {src}', file=sys.stderr)
            continue
        moves.append((src, dest))

    if dry_run:
        for src, dest in moves:
            print(f'  {src.relative_to(REPO)} -> {dest.relative_to(REPO)}')
        return

    for src, dest in moves:
        dest.parent.mkdir(parents=True, exist_ok=True)
        subprocess.run(['git', 'mv', str(src), str(dest)],
                       check=True, cwd=REPO)
        content = dest.read_text()
        package = package_for(dest)
        sol_num = solution_number(dest.name)
        new_content = _transform_for(provider, content, package, sol_num)
        dest.write_text(new_content)

    provider_java_root = JAVA_ROOT / provider
    for problem_dir in provider_java_root.rglob('*'):
        if not problem_dir.is_dir():
            continue
        if not any(problem_dir.glob('Solution*.java')):
            continue
        readme = problem_dir / 'README.md'
        if not readme.exists():
            readme.write_text(readme_for(problem_dir))


def main() -> int:
    ap = argparse.ArgumentParser(description=__doc__)
    ap.add_argument('--provider', required=True,
                    choices=['algoexpert', 'codesignal', 'educative'])
    ap.add_argument('--dry-run', action='store_true',
                    help='Print planned moves; do not modify the working tree.')
    args = ap.parse_args()
    migrate_provider(args.provider, dry_run=args.dry_run)
    return 0


if __name__ == '__main__':
    sys.exit(main())
