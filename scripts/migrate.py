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
}


def kebab_to_snake(name: str) -> str:
    return name.replace('-', '_')


def problem_to_snake(name: str) -> str:
    return SPECIAL_PROBLEM_RENAMES.get(name, kebab_to_snake(name))


def new_path_for(src: Path) -> Path | None:
    """Map a legacy source path to its destination under JAVA_ROOT.

    Returns None if the file is outside any known provider root.
    """
    try:
        rel = src.relative_to(REPO)
    except ValueError:
        return None
    parts = rel.parts
    if not parts:
        return None
    if parts[0] == 'algoexpert.io':
        _, tier, problem, fname = parts
        return (JAVA_ROOT / 'algoexpert' / ALGOEXPERT_TIER[tier]
                / problem_to_snake(problem) / fname)
    if parts[0] == 'codesignal.com':
        _, section, problem, fname = parts
        m = re.fullmatch(r'solution-(\d+)\.java', fname)
        if m:
            fname = f'Solution{m.group(1)}.java'
        return (JAVA_ROOT / 'codesignal' / CODESIGNAL_SECTION[section]
                / problem_to_snake(problem) / fname)
    if parts[0] == 'educative.io':
        _, _, pattern, problem, fname = parts
        return (JAVA_ROOT / 'educative' / 'patterns'
                / problem_to_snake(pattern) / problem_to_snake(problem)
                / fname)
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

    sol_files = sorted(f.name for f in problem_dir.glob('Solution*.java'))
    rows = '\n'.join(
        f'| {f.replace(".java", "")} | TODO | TODO | TODO |' for f in sol_files
    ) or '| Solution1 | TODO | TODO | TODO |'

    return (
        f'# {title}\n\n'
        f'![Difficulty](https://img.shields.io/badge/difficulty-{difficulty}-{color})\n'
        f'**Source:** {source}\n\n'
        '<!-- TODO: paraphrase the problem in your own words. -->\n\n'
        '**Solutions**\n\n'
        '| File | Approach | Time | Space |\n'
        '|---|---|---|---|\n'
        f'{rows}\n'
    )
