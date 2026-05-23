#!/usr/bin/env python3
"""Post-migration helper: copy each Solution{N}'s Approach phrase from its
problem's README.md into the `// Approach: TODO.` placeholder of the
corresponding Java file.

For every problem directory under java/src/main/java/, this script:
  1. Reads README.md and parses the solutions table.
  2. For each row that names a Solution{N} and an Approach value, opens
     Solution{N}.java in the same directory.
  3. Replaces the line `// Approach: TODO.` with `// Approach: <value>.`
     leaving everything else unchanged.

Idempotent: if the file already has a non-TODO Approach line, it is left
alone. Files with no `// Approach:` line at all are skipped.
"""

import re
import sys
from pathlib import Path

REPO = Path(__file__).resolve().parent.parent
JAVA_ROOT = REPO / 'java' / 'src' / 'main' / 'java'


def parse_solutions_table(readme: Path) -> dict[str, str]:
    """Parse the markdown solutions table from a problem's README.

    Returns a mapping of `Solution{N}` -> Approach string. Skips rows whose
    approach is `TODO` or the dash placeholder used for empty stubs.
    """
    text = readme.read_text()
    out: dict[str, str] = {}
    for line in text.splitlines():
        if not line.startswith('| Solution'):
            continue
        cells = [c.strip() for c in line.strip('|').split('|')]
        if len(cells) < 2:
            continue
        name, approach = cells[0], cells[1]
        if not re.fullmatch(r'Solution\d+', name):
            continue
        if approach in ('TODO', '-', '—', ''):
            continue
        out[name] = approach
    return out


def fill_one_solution(java_file: Path, approach: str) -> bool:
    """Replace `// Approach: TODO.` in java_file with the given approach.
    Returns True if the file was changed, False otherwise.
    """
    if not java_file.exists():
        return False
    content = java_file.read_text()
    if '// Approach: TODO.' not in content:
        return False
    new_content = content.replace(
        '// Approach: TODO.',
        f'// Approach: {approach}.',
        1,
    )
    if new_content == content:
        return False
    java_file.write_text(new_content)
    return True


def main() -> int:
    if not JAVA_ROOT.exists():
        print(f'JAVA_ROOT not found: {JAVA_ROOT}', file=sys.stderr)
        return 1
    changed = 0
    skipped_no_approach_line = 0
    skipped_no_table_entry = 0
    for readme in JAVA_ROOT.rglob('README.md'):
        problem_dir = readme.parent
        table = parse_solutions_table(readme)
        for java_file in problem_dir.glob('Solution*.java'):
            name = java_file.stem
            approach = table.get(name)
            if approach is None:
                skipped_no_table_entry += 1
                continue
            if fill_one_solution(java_file, approach):
                changed += 1
            else:
                skipped_no_approach_line += 1
    print(f'changed: {changed}')
    print(f'skipped (no approach line): {skipped_no_approach_line}')
    print(f'skipped (no table entry): {skipped_no_table_entry}')
    return 0


if __name__ == '__main__':
    sys.exit(main())
