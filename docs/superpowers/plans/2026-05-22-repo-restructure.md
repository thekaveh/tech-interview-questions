# Repo Restructure Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Migrate this repo from a flat provider-rooted snippet collection into a buildable Maven-based Java project under `java/src/main/java/`, while preserving every solution's body byte-for-byte and leaving the door open for additional language trees.

**Architecture:** A one-shot Python migration script (`scripts/migrate.py`) computes destination paths, uses `git mv` to preserve per-file history, applies per-provider content transforms (package declaration, class wrapping for bare CodeSignal functions, class renames for problem-named Educative classes), and emits a `README.md` template per problem directory. Migration runs in three separate commits — one per provider — so each diff is reviewable and each provider's `mvn -B compile` pass can be verified independently.

**Tech Stack:**
- Java 17 (LTS) compiled via Maven 3.9+
- Python 3.11+ (stdlib only — `pathlib`, `re`, `subprocess`, `unittest`) for the migration tool
- GitHub Actions for CI

**Spec:** [`../specs/2026-05-22-repo-restructure-design.md`](../specs/2026-05-22-repo-restructure-design.md)

---

## File Structure

**New files created by this plan:**

| Path | Responsibility |
|---|---|
| `LICENSE` | MIT license, 2026, Kaveh Razavi |
| `README.md` (rewrite) | Repo landing page: what it is, layout, build command, badge legend |
| `java/pom.xml` | Maven build configuration; JDK 17, no dependencies |
| `.github/workflows/java-build.yml` | CI workflow running `mvn -B compile` on push/PR |
| `.gitignore` (additions) | `target/`, `__pycache__/`, `.idea/` |
| `scripts/migrate.py` | One-shot migration tool with per-provider transforms |
| `scripts/test_migrate.py` | Unit tests for `migrate.py` |
| `java/src/main/java/algoexpert/{easy,medium,hard,veryhard}/<problem>/` | Migrated AlgoExpert solutions + READMEs |
| `java/src/main/java/codesignal/{intro,thecore}/<problem>/` | Migrated CodeSignal solutions + READMEs |
| `java/src/main/java/educative/patterns/<pattern>/<problem>/` | Migrated Educative solutions + READMEs |

**Files modified or deleted:**

| Path | Change |
|---|---|
| `CLAUDE.md` | Updated directory layout section; removed CodeSignal bare-function paragraph |
| `algoexpert.io/`, `codesignal.com/`, `educative.io/` | Deleted (empty after migration) |

**Migration script boundaries:**

`scripts/migrate.py` has one responsibility per function group:
- *Path transforms* (`new_path_for`, `kebab_to_snake`, `problem_to_snake`, `package_for`): legacy path → destination path and package.
- *Content transforms* (`transform_algoexpert`, `transform_codesignal`, `transform_educative`): in-place edits to file contents.
- *README generation* (`readme_for`, `title_from_problem`): emits `README.md` per problem directory.
- *Orchestrator* (`migrate_provider`, `main`): walks the tree, calls `git mv`, applies transforms, writes READMEs.

Tests in `scripts/test_migrate.py` exercise each group with small fixtures; the orchestrator is tested via a `--dry-run` flag on the real tree before running for real.

---

## Task 1: Bootstrap repo structure

**Files:**
- Create: `LICENSE`
- Create: `java/pom.xml`
- Create: `.github/workflows/java-build.yml`
- Create: `java/src/main/java/.gitkeep`
- Modify: `README.md` (full rewrite)
- Modify: `.gitignore` (add entries)

- [ ] **Step 1: Create `LICENSE` (MIT)**

Create `LICENSE` with this content:

```
MIT License

Copyright (c) 2026 Kaveh Razavi

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

- [ ] **Step 2: Create `java/pom.xml`**

Create `java/pom.xml`:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                             http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.thekaveh</groupId>
  <artifactId>tech-interview-questions-java</artifactId>
  <version>1.0.0-SNAPSHOT</version>
  <packaging>jar</packaging>

  <properties>
    <maven.compiler.release>17</maven.compiler.release>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>

  <build>
    <plugins>
      <plugin>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.13.0</version>
      </plugin>
    </plugins>
  </build>
</project>
```

- [ ] **Step 3: Create `java/src/main/java/.gitkeep`**

Create empty file `java/src/main/java/.gitkeep` so the directory tracks before migration runs.

- [ ] **Step 4: Verify pom is valid (run `mvn validate`)**

Run from repo root:

```bash
cd java && mvn -B -q validate && cd ..
```

Expected: exit code 0, no errors. If `mvn` is not installed, install via Homebrew (`brew install maven`).

- [ ] **Step 5: Create CI workflow**

Create `.github/workflows/java-build.yml`:

```yaml
name: java-build
on:
  push:
    branches: [main]
  pull_request:
jobs:
  compile:
    runs-on: ubuntu-latest
    defaults:
      run:
        working-directory: java
    steps:
      - uses: actions/checkout@v4
      - uses: actions/setup-java@v4
        with:
          distribution: temurin
          java-version: '17'
          cache: maven
      - run: mvn -B compile
```

- [ ] **Step 6: Update `.gitignore`**

Add to `.gitignore` (append to existing content):

```
# maven
target/

# python migration tool
__pycache__/
*.pyc

# IDE
.idea/
*.iml
```

- [ ] **Step 7: Rewrite top-level `README.md`**

Replace existing one-line `README.md` with:

````markdown
# Tech Interview Questions

[![build](https://github.com/thekaveh/tech-interview-questions/actions/workflows/java-build.yml/badge.svg)](https://github.com/thekaveh/tech-interview-questions/actions/workflows/java-build.yml)

A personal collection of solved coding-interview problems from AlgoExpert,
CodeSignal, and Educative. Solutions are my own work; problem statements in
each `README.md` are paraphrased in my own words.

## Layout

```
java/                              ← Java solutions (active)
  src/main/java/
    algoexpert/{easy,medium,hard,veryhard}/<problem>/
    codesignal/{intro,thecore}/<problem>/
    educative/patterns/<pattern>/<problem>/
python/                            ← reserved for future
```

Each `<problem>/` directory contains a `README.md` (problem summary,
difficulty badge, complexity table) and one or more `SolutionN.java` files,
where the number denotes attempt order. The `// Approach:` comment in each
file names the technique used.

## Building

```
cd java
mvn -B compile
```

Requires JDK 17+. There are no runtime dependencies; the build only verifies
that all solutions compile.

## Difficulty badges

- ![warmup](https://img.shields.io/badge/-warm--up-green) — elementary, FizzBuzz-tier
- ![easy](https://img.shields.io/badge/-easy-yellowgreen)
- ![medium](https://img.shields.io/badge/-medium-yellow)
- ![hard](https://img.shields.io/badge/-hard-orange)
- ![very-hard](https://img.shields.io/badge/-very--hard-red)

The badge value defaults from the source tier but is labeled honestly per
problem — some "easy"-tier problems are really warm-ups.

## License

[MIT](./LICENSE)
````

- [ ] **Step 8: Verify nothing breaks**

Run:

```bash
cd java && mvn -B -q compile && cd ..
```

Expected: exit code 0. The compile passes because `src/main/java/` is empty (only `.gitkeep`); Maven happily compiles zero sources.

- [ ] **Step 9: Commit**

```bash
git add LICENSE README.md .gitignore java/pom.xml java/src/main/java/.gitkeep .github/workflows/java-build.yml
git commit -m "build: scaffold maven + ci + license"
```

---

## Task 2: Migration script — path transforms and README generator

**Files:**
- Create: `scripts/migrate.py`
- Create: `scripts/test_migrate.py`

- [ ] **Step 1: Write failing tests for path transforms**

Create `scripts/test_migrate.py`:

```python
import unittest
from pathlib import Path
from migrate import (
    kebab_to_snake, problem_to_snake, new_path_for, package_for,
    title_from_problem, readme_for, REPO, JAVA_ROOT,
)


class TestPathTransforms(unittest.TestCase):
    def test_kebab_to_snake(self):
        self.assertEqual(kebab_to_snake('two-number-sum'), 'two_number_sum')
        self.assertEqual(kebab_to_snake('intro'), 'intro')
        self.assertEqual(kebab_to_snake('a-b-c-d'), 'a_b_c_d')

    def test_problem_to_snake_handles_camelcase_outlier(self):
        self.assertEqual(problem_to_snake('isDigit'), 'is_digit')
        self.assertEqual(problem_to_snake('two-number-sum'), 'two_number_sum')

    def test_new_path_algoexpert(self):
        src = REPO / 'algoexpert.io' / 'easy' / 'two-number-sum' / 'Solution1.java'
        dest = new_path_for(src)
        self.assertEqual(
            dest,
            JAVA_ROOT / 'algoexpert' / 'easy' / 'two_number_sum' / 'Solution1.java',
        )

    def test_new_path_algoexpert_very_hard_tier(self):
        src = REPO / 'algoexpert.io' / 'very-hard' / 'foo-bar' / 'Solution2.java'
        dest = new_path_for(src)
        self.assertEqual(
            dest,
            JAVA_ROOT / 'algoexpert' / 'veryhard' / 'foo_bar' / 'Solution2.java',
        )

    def test_new_path_codesignal_filename_renamed(self):
        src = REPO / 'codesignal.com' / 'intro' / 'adjacent-elements-product' / 'solution-1.java'
        dest = new_path_for(src)
        self.assertEqual(
            dest,
            JAVA_ROOT / 'codesignal' / 'intro' / 'adjacent_elements_product' / 'Solution1.java',
        )

    def test_new_path_codesignal_the_core(self):
        src = REPO / 'codesignal.com' / 'the-core' / 'apple-boxes' / 'solution-1.java'
        dest = new_path_for(src)
        self.assertEqual(
            dest,
            JAVA_ROOT / 'codesignal' / 'thecore' / 'apple_boxes' / 'Solution1.java',
        )

    def test_new_path_codesignal_camelcase_outlier(self):
        src = REPO / 'codesignal.com' / 'intro' / 'isDigit' / 'solution-1.java'
        dest = new_path_for(src)
        self.assertEqual(
            dest,
            JAVA_ROOT / 'codesignal' / 'intro' / 'is_digit' / 'Solution1.java',
        )

    def test_new_path_educative_collapses_patterns_prefix(self):
        src = (REPO / 'educative.io' / 'patterns-for-coding-questions'
               / 'sliding-window' / 'fruits-into-baskets' / 'Solution1.java')
        dest = new_path_for(src)
        self.assertEqual(
            dest,
            JAVA_ROOT / 'educative' / 'patterns' / 'sliding_window' / 'fruits_into_baskets' / 'Solution1.java',
        )

    def test_package_for(self):
        dest = JAVA_ROOT / 'algoexpert' / 'easy' / 'two_number_sum' / 'Solution1.java'
        self.assertEqual(package_for(dest), 'algoexpert.easy.two_number_sum')


class TestReadmeGenerator(unittest.TestCase):
    def test_title_from_problem(self):
        self.assertEqual(title_from_problem('two_number_sum'), 'Two Number Sum')
        self.assertEqual(title_from_problem('is_digit'), 'Is Digit')

    def test_readme_for_algoexpert_easy(self, tmp_root=None):
        import tempfile, os
        with tempfile.TemporaryDirectory() as tmp:
            problem_dir = Path(tmp) / 'java' / 'src' / 'main' / 'java' / 'algoexpert' / 'easy' / 'two_number_sum'
            problem_dir.mkdir(parents=True)
            (problem_dir / 'Solution1.java').write_text('')
            (problem_dir / 'Solution2.java').write_text('')
            # patch JAVA_ROOT for the test
            import migrate
            original = migrate.JAVA_ROOT
            migrate.JAVA_ROOT = Path(tmp) / 'java' / 'src' / 'main' / 'java'
            try:
                out = readme_for(problem_dir)
            finally:
                migrate.JAVA_ROOT = original
        self.assertIn('# Two Number Sum', out)
        self.assertIn('difficulty-warm--up-green', out)
        self.assertIn('**Source:** AlgoExpert', out)
        self.assertIn('| Solution1 | TODO | TODO | TODO |', out)
        self.assertIn('| Solution2 | TODO | TODO | TODO |', out)


if __name__ == '__main__':
    unittest.main()
```

- [ ] **Step 2: Run tests, confirm they fail with import errors**

```bash
cd scripts && python3 -m unittest test_migrate -v && cd ..
```

Expected: `ModuleNotFoundError: No module named 'migrate'` — tests fail because `migrate.py` doesn't exist yet.

- [ ] **Step 3: Implement `scripts/migrate.py` foundation**

Create `scripts/migrate.py`:

```python
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
```

- [ ] **Step 4: Run tests, confirm they pass**

```bash
cd scripts && python3 -m unittest test_migrate -v && cd ..
```

Expected: 10 tests run, all pass.

- [ ] **Step 5: Commit**

```bash
git add scripts/migrate.py scripts/test_migrate.py
git commit -m "scripts: migration tool foundation (path transforms + readme)"
```

---

## Task 3: Migration script — content transforms per provider

**Files:**
- Modify: `scripts/migrate.py` (add three transform functions)
- Modify: `scripts/test_migrate.py` (add tests for each transform)

- [ ] **Step 1: Write failing tests for content transforms**

Append to `scripts/test_migrate.py` (before `if __name__`):

```python
from migrate import (
    transform_algoexpert, transform_codesignal, transform_educative,
    solution_number,
)


ALGOEXPERT_INPUT = """import java.util.*;

class Solution1 {
    public static int[] twoNumberSum(int[] A, int S) {
        return new int[0];
    }
}
"""

ALGOEXPERT_EXPECTED = """package algoexpert.easy.two_number_sum;
import java.util.*;

// Approach: TODO.
class Solution1 {
    public static int[] twoNumberSum(int[] A, int S) {
        return new int[0];
    }
}
"""


CODESIGNAL_BARE_INPUT = """int solution(int[] A) {
    var N = A.length;
    return N;
}
"""

CODESIGNAL_BARE_EXPECTED = """package codesignal.intro.adj.product;
import java.util.*;

// Approach: TODO.
class Solution1 {
    static int solution(int[] A) {
        var N = A.length;
        return N;
    }
}
"""


CODESIGNAL_CLASS_INPUT = """class Solution {
    int solution(int param1, int param2) {
        return param1 + param2;
    }
}
"""

CODESIGNAL_CLASS_EXPECTED = """package codesignal.thecore.add_two;
import java.util.*;

// Approach: TODO.
class Solution1 {
    static int solution(int param1, int param2) {
        return param1 + param2;
    }
}
"""


CODESIGNAL_TYPO_INPUT = """import javax.lang.model.util.ElementScanner6;

class SOlution {
    int solution(int n, int l, int r) {
        return 0;
    }
}
"""

CODESIGNAL_TYPO_EXPECTED = """package codesignal.thecore.count_sum;
import javax.lang.model.util.ElementScanner6;
import java.util.*;

// Approach: TODO.
class Solution1 {
    static int solution(int n, int l, int r) {
        return 0;
    }
}
"""


EDUCATIVE_INPUT = """class MaxSumSubArrayOfSizeK {
\tpublic static int findMaxSumSubArray(int k, int[] A) {
\t\tint N = A.length;
\t\treturn N;
\t}
}
"""

EDUCATIVE_EXPECTED = """package educative.patterns.sliding_window.max_sum_subarray_of_size_k;
import java.util.*;

// Approach: TODO.
class Solution1 {
\tpublic static int findMaxSumSubArray(int k, int[] A) {
\t\tint N = A.length;
\t\treturn N;
\t}
}
"""


EDUCATIVE_WITH_IMPORT_INPUT = """import java.util.*;

class StringPermutation {
\tpublic static boolean findPermutation(String s, String p) {
\t\treturn false;
\t}
}
"""

EDUCATIVE_WITH_IMPORT_EXPECTED = """package educative.patterns.sliding_window.find_permutation_in_a_string;
import java.util.*;

// Approach: TODO.
class Solution1 {
\tpublic static boolean findPermutation(String s, String p) {
\t\treturn false;
\t}
}
"""


class TestSolutionNumber(unittest.TestCase):
    def test_solution_number(self):
        self.assertEqual(solution_number('Solution1.java'), 1)
        self.assertEqual(solution_number('Solution2.java'), 2)
        self.assertEqual(solution_number('Solution12.java'), 12)


class TestTransformAlgoexpert(unittest.TestCase):
    def test_prepends_package_and_approach_line(self):
        out = transform_algoexpert(ALGOEXPERT_INPUT, 'algoexpert.easy.two_number_sum')
        self.assertEqual(out, ALGOEXPERT_EXPECTED)


class TestTransformCodesignal(unittest.TestCase):
    def test_wraps_bare_function_and_makes_static(self):
        out = transform_codesignal(CODESIGNAL_BARE_INPUT,
                                   'codesignal.intro.adj.product', 1)
        self.assertEqual(out, CODESIGNAL_BARE_EXPECTED)

    def test_renames_existing_class_and_makes_method_static(self):
        out = transform_codesignal(CODESIGNAL_CLASS_INPUT,
                                   'codesignal.thecore.add_two', 1)
        self.assertEqual(out, CODESIGNAL_CLASS_EXPECTED)

    def test_preserves_existing_imports_and_handles_class_typo(self):
        out = transform_codesignal(CODESIGNAL_TYPO_INPUT,
                                   'codesignal.thecore.count_sum', 1)
        self.assertEqual(out, CODESIGNAL_TYPO_EXPECTED)


class TestTransformEducative(unittest.TestCase):
    def test_renames_class_and_adds_import(self):
        out = transform_educative(
            EDUCATIVE_INPUT,
            'educative.patterns.sliding_window.max_sum_subarray_of_size_k',
            1,
        )
        self.assertEqual(out, EDUCATIVE_EXPECTED)

    def test_preserves_existing_import(self):
        out = transform_educative(
            EDUCATIVE_WITH_IMPORT_INPUT,
            'educative.patterns.sliding_window.find_permutation_in_a_string',
            1,
        )
        self.assertEqual(out, EDUCATIVE_WITH_IMPORT_EXPECTED)
```

- [ ] **Step 2: Run tests, confirm new ones fail with ImportError**

```bash
cd scripts && python3 -m unittest test_migrate -v && cd ..
```

Expected: `ImportError: cannot import name 'transform_algoexpert' from 'migrate'` and similar for the others.

- [ ] **Step 3: Implement content transforms in `scripts/migrate.py`**

Append to `scripts/migrate.py` after the README section:

```python
# --- Source file transforms ------------------------------------------

APPROACH_LINE = '// Approach: TODO.'


def solution_number(fname: str) -> int:
    m = re.fullmatch(r'Solution(\d+)\.java', fname)
    if not m:
        raise ValueError(f'unexpected filename: {fname}')
    return int(m.group(1))


def transform_algoexpert(content: str, package: str) -> str:
    """AlgoExpert: prepend `package`; insert Approach line above the class.

    AlgoExpert files reliably start with `import java.util.*;` and contain
    `class SolutionN { ... }`. No class rename or import injection needed.
    """
    body = content
    body = re.sub(
        r'(\nclass Solution\d+ \{)',
        f'\n{APPROACH_LINE}\\1',
        body,
        count=1,
    )
    return f'package {package};\n{body}'


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


def transform_codesignal(content: str, package: str, sol_num: int) -> str:
    """CodeSignal files come in two shapes:
       (a) bare function at top level: `int solution(...) { ... }`
       (b) already wrapped: `class Solution { int solution(...) {...} }`
    Some have imports; some have the class-name typo `SOlution`."""
    imports, body = _split_imports(content)
    imports = _ensure_java_util_import(imports)
    body = body.rstrip() + '\n'

    has_class = bool(re.search(r'^class [A-Za-z_]\w*\s*\{', body, re.MULTILINE))
    if has_class:
        # Rename the class to SolutionN.
        body = re.sub(
            r'^class [A-Za-z_]\w*\s*\{',
            f'class Solution{sol_num} {{',
            body,
            count=1,
            flags=re.MULTILINE,
        )
        # First method inside the class is at 4-space indent; make it static
        # if it isn't already. Method line pattern: 4 spaces, optional
        # access modifier, return type, name, '('.
        body = re.sub(
            r'^(    )(?!static\b)(?!public\s+static\b)'
            r'((?:public\s+|private\s+|protected\s+)?'
            r'[A-Za-z_][\w\[\]<>]*\s+[A-Za-z_]\w*\s*\()',
            r'\1static \2',
            body,
            count=1,
            flags=re.MULTILINE,
        )
        new_body = body
    else:
        # Wrap bare body in a class. Indent everything by 4 spaces.
        indented = '\n'.join(('    ' + ln) if ln else ln
                             for ln in body.rstrip('\n').split('\n'))
        # First line of the indented body is a function def at col 4 — make it static.
        indented = re.sub(
            r'^(    )(?!static\b)([A-Za-z_][\w\[\]<>]*\s+[A-Za-z_]\w*\s*\()',
            r'\1static \2',
            indented,
            count=1,
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
    imports, body = _split_imports(content)
    imports = _ensure_java_util_import(imports)
    body = body.rstrip() + '\n'

    body = re.sub(
        r'^class [A-Za-z_]\w*\s*\{',
        f'class Solution{sol_num} {{',
        body,
        count=1,
        flags=re.MULTILINE,
    )

    imports_block = '\n'.join(imports)
    return (
        f'package {package};\n'
        f'{imports_block}\n\n'
        f'{APPROACH_LINE}\n'
        f'{body}'
    )
```

- [ ] **Step 4: Run tests, all pass**

```bash
cd scripts && python3 -m unittest test_migrate -v && cd ..
```

Expected: 18 tests run, all pass.

- [ ] **Step 5: Commit**

```bash
git add scripts/migrate.py scripts/test_migrate.py
git commit -m "scripts: per-provider content transforms with unit tests"
```

---

## Task 4: Migration script — orchestrator

**Files:**
- Modify: `scripts/migrate.py` (add `migrate_provider` + CLI `main`)

- [ ] **Step 1: Add orchestrator + CLI to `scripts/migrate.py`**

Append to `scripts/migrate.py`:

```python
# --- Orchestrator ----------------------------------------------------

PROVIDER_ROOTS = {
    'algoexpert': 'algoexpert.io',
    'codesignal': 'codesignal.com',
    'educative':  'educative.io',
}


def _transform_for(provider: str, content: str, package: str, sol_num: int) -> str:
    if provider == 'algoexpert':
        return transform_algoexpert(content, package)
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
```

- [ ] **Step 2: Run existing tests still pass**

```bash
cd scripts && python3 -m unittest test_migrate -v && cd ..
```

Expected: 18 tests, all pass.

- [ ] **Step 3: Spot-check the CLI with `--dry-run` (does not modify files)**

```bash
python3 scripts/migrate.py --provider algoexpert --dry-run | head -10
```

Expected output shape (first lines):

```
algoexpert: 168 file(s) to migrate
  algoexpert.io/easy/branch-sums/Solution1.java -> java/src/main/java/algoexpert/easy/branch_sums/Solution1.java
  ...
```

If file counts differ, do not proceed — the legacy tree shape was misread. Diagnose before continuing.

- [ ] **Step 4: Commit**

```bash
git add scripts/migrate.py
git commit -m "scripts: orchestrator + CLI for migration tool"
```

---

## Task 5: Dry-run all three providers and spot-check

**Files:**
- (no modifications)

- [ ] **Step 1: Dry-run all three providers**

```bash
python3 scripts/migrate.py --provider algoexpert --dry-run | tail -5
python3 scripts/migrate.py --provider codesignal --dry-run | tail -5
python3 scripts/migrate.py --provider educative  --dry-run | tail -5
```

Expected: each prints `<provider>: <N> file(s) to migrate` and a final few path-mapping lines.

Sanity check the totals against the known legacy counts:

```bash
echo "legacy algoexpert: $(find algoexpert.io -name '*.java' | wc -l)"
echo "legacy codesignal: $(find codesignal.com -name '*.java' | wc -l)"
echo "legacy educative:  $(find educative.io -name '*.java' | wc -l)"
```

The dry-run "files to migrate" number must match each. If not, diagnose before proceeding.

- [ ] **Step 2: Visually verify one mapping per provider**

Confirm:
- `algoexpert.io/very-hard/<something>/Solution1.java -> java/src/main/java/algoexpert/veryhard/<snake>/Solution1.java`
- `codesignal.com/the-core/<something>/solution-1.java -> java/src/main/java/codesignal/thecore/<snake>/Solution1.java`
- `codesignal.com/intro/isDigit/solution-1.java -> java/src/main/java/codesignal/intro/is_digit/Solution1.java`
- `educative.io/patterns-for-coding-questions/sliding-window/<something>/Solution1.java -> java/src/main/java/educative/patterns/sliding_window/<snake>/Solution1.java`

Grep the dry-run output for each pattern and confirm presence:

```bash
python3 scripts/migrate.py --provider algoexpert --dry-run | grep 'veryhard' | head -1
python3 scripts/migrate.py --provider codesignal --dry-run | grep 'is_digit'
python3 scripts/migrate.py --provider educative  --dry-run | grep 'sliding_window' | head -1
```

Expected: each grep produces at least one match.

- [ ] **Step 3: Verify clean tree**

```bash
git status --porcelain
```

Expected: empty (no uncommitted changes). Dry-run does not modify files.

---

## Task 6: Migrate AlgoExpert

**Files:**
- Move: `algoexpert.io/**/*.java` → `java/src/main/java/algoexpert/**/*.java`
- Create: one `README.md` per problem directory under `algoexpert/`

- [ ] **Step 1: Run the migration**

```bash
python3 scripts/migrate.py --provider algoexpert
```

Expected output ends with `algoexpert: 168 file(s) to migrate` (count may differ if `git ls-files` differs — just confirm no errors).

- [ ] **Step 2: Confirm legacy tree drained but not yet deleted**

```bash
find algoexpert.io -name '*.java' | wc -l
```

Expected: `0`. Empty directories will be cleaned up in Task 9.

- [ ] **Step 3: Run `mvn -B compile`**

```bash
cd java && mvn -B compile && cd ..
```

Expected: `BUILD SUCCESS`.

If `BUILD FAILURE`: the migration script produced an invalid file. Inspect the first compile error, look at the offending file, identify the regex that mishandled it. Fix the regex in `scripts/migrate.py`, **revert the migration** with `git restore --source=HEAD --staged --worktree .` (CAUTION: this is reversible only because nothing is committed yet), and re-run.

- [ ] **Step 4: Spot-check a migrated file**

```bash
head -8 java/src/main/java/algoexpert/easy/two_number_sum/Solution1.java
```

Expected:

```java
package algoexpert.easy.two_number_sum;
import java.util.*;

// Approach: TODO.
class Solution1 {
    public static int[] twoNumberSum(int[] A, int S) {
```

- [ ] **Step 5: Spot-check a generated README**

```bash
cat java/src/main/java/algoexpert/easy/two_number_sum/README.md
```

Expected:

```markdown
# Two Number Sum

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** AlgoExpert

<!-- TODO: paraphrase the problem in your own words. -->

**Solutions**

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | TODO | TODO | TODO |
| Solution2 | TODO | TODO | TODO |
| Solution3 | TODO | TODO | TODO |
```

- [ ] **Step 6: Commit**

```bash
git add -A
git commit -m "refactor: migrate algoexpert solutions into java/src/main/java"
```

---

## Task 7: Migrate CodeSignal

**Files:**
- Move: `codesignal.com/**/*.java` → `java/src/main/java/codesignal/**/*.java`
- Create: per-problem `README.md`s

- [ ] **Step 1: Run the migration**

```bash
python3 scripts/migrate.py --provider codesignal
```

Expected: prints `codesignal: 151 file(s) to migrate` (113 bare + 38 class-wrapped; recount with the legacy `find` if uncertain).

- [ ] **Step 2: Confirm legacy tree drained**

```bash
find codesignal.com -name '*.java' | wc -l
```

Expected: `0`.

- [ ] **Step 3: Run `mvn -B compile`**

```bash
cd java && mvn -B compile && cd ..
```

Expected: `BUILD SUCCESS`.

If `BUILD FAILURE`: the codesignal transform is the most complex (bare-vs-wrapped, typo `SOlution`, varied imports). Identify the failing file:

```bash
cd java && mvn -B compile 2>&1 | grep -E 'ERROR|error:' | head -10 && cd ..
```

Common failure modes:
- Method signature didn't get `static` prepended (e.g., `boolean solution(...)` started with `boolean` matched the regex's `[A-Za-z_]\w*` for return type but had unusual syntax). Inspect the file, fix `transform_codesignal`, revert and re-run.
- File had a class wrapper with the method already `public` or `private` — the regex `(?!public\s+static\b)` covers most but not all combinations. If found, add to the regex's negative lookahead.

To revert and retry: `git restore --source=HEAD --staged --worktree . && git clean -fd java/src/main/java/codesignal/`. Then fix and re-run.

- [ ] **Step 4: Spot-check a wrapped (formerly bare) file**

```bash
head -8 java/src/main/java/codesignal/intro/adjacent_elements_product/Solution1.java
```

Expected:

```java
package codesignal.intro.adjacent_elements_product;
import java.util.*;

// Approach: TODO.
class Solution1 {
    static int solution(int[] A) {
        var N = A.length;
```

- [ ] **Step 5: Spot-check a formerly class-wrapped file**

```bash
head -8 java/src/main/java/codesignal/thecore/apple_boxes/Solution1.java
```

Expected:

```java
package codesignal.thecore.apple_boxes;
import java.util.*;

// Approach: TODO.
class Solution1 {
    static int solution(int k) {
        var ret = 0;
```

- [ ] **Step 6: Commit**

```bash
git add -A
git commit -m "refactor: migrate codesignal solutions into java/src/main/java"
```

---

## Task 8: Migrate Educative

**Files:**
- Move: `educative.io/**/*.java` → `java/src/main/java/educative/patterns/**/*.java`
- Create: per-problem `README.md`s

- [ ] **Step 1: Run the migration**

```bash
python3 scripts/migrate.py --provider educative
```

Expected: prints `educative: <N> file(s) to migrate`. Compare to:

```bash
find educative.io -name '*.java' | wc -l
```

Counts must match.

- [ ] **Step 2: Confirm legacy tree drained**

```bash
find educative.io -name '*.java' | wc -l
```

Expected: `0`.

- [ ] **Step 3: Run `mvn -B compile`**

```bash
cd java && mvn -B compile && cd ..
```

Expected: `BUILD SUCCESS`.

If `BUILD FAILURE`: the educative transform renames `class <ProblemName>` to `class Solution<N>`. Failure modes:
- A file had no `class` declaration at all (some Educative files are mid-pattern fragments?). The regex makes one substitution; if none occurred, the file remains without a class.
- A class name had unusual characters. Adjust the regex.

Diagnose, fix, revert with `git restore --source=HEAD --staged --worktree . && git clean -fd java/src/main/java/educative/`, re-run.

- [ ] **Step 4: Spot-check a migrated file**

```bash
head -8 java/src/main/java/educative/patterns/sliding_window/maximum_sum_subarray_of_size_k/Solution1.java
```

Expected:

```java
package educative.patterns.sliding_window.maximum_sum_subarray_of_size_k;
import java.util.*;

// Approach: TODO.
class Solution1 {
	public static int findMaxSumSubArray(int k, int[] A) {
```

- [ ] **Step 5: Commit**

```bash
git add -A
git commit -m "refactor: migrate educative solutions into java/src/main/java"
```

---

## Task 9: Cleanup and finalize

**Files:**
- Delete: `algoexpert.io/`, `codesignal.com/`, `educative.io/` (empty after migration)
- Delete: `java/src/main/java/.gitkeep` (no longer needed)
- Modify: `CLAUDE.md` (rewrite directory-layout section)

- [ ] **Step 1: Delete empty legacy directories**

```bash
find algoexpert.io codesignal.com educative.io -type d -empty -delete 2>/dev/null
ls algoexpert.io codesignal.com educative.io 2>&1 | head -5
```

Expected: directories no longer exist (`ls: cannot access ...: No such file or directory`).

- [ ] **Step 2: Remove `.gitkeep`**

```bash
git rm java/src/main/java/.gitkeep
```

Expected: `rm 'java/src/main/java/.gitkeep'`.

- [ ] **Step 3: Update `CLAUDE.md`**

Replace the entire content of `CLAUDE.md` with:

````markdown
# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## What this repo is

A personal collection of solved coding-interview problems from AlgoExpert,
CodeSignal, and Educative. Java solutions live under `java/src/main/java/`
and are built with Maven. The migration script `scripts/migrate.py` is the
authoritative record of how the legacy layout was reshaped.

## Layout

```
java/
  pom.xml
  src/main/java/
    algoexpert/{easy,medium,hard,veryhard}/<problem_snake>/
    codesignal/{intro,thecore}/<problem_snake>/
    educative/patterns/<pattern_snake>/<problem_snake>/
scripts/migrate.py            ← one-shot migration tool, kept for reference
docs/superpowers/             ← brainstorming specs and implementation plans
.github/workflows/java-build.yml   ← CI runs `mvn -B compile`
```

Each `<problem_snake>/` directory contains:
- `README.md` — title, difficulty badge, source, paraphrased statement, and
  a solutions table mapping `SolutionN` to approach/time/space. Fields that
  weren't auto-derivable are marked `TODO`.
- One or more `Solution{N}.java` files where `N` is attempt order.

## House code style

- `import java.util.*;` wildcard imports.
- `var` for local variables wherever the type is inferable.
- Terse identifiers for ubiquitous quantities: `N` = length/size, `R` = result,
  `S` = running sum, `lo`/`hi`/`mid` for pointers.
- Aligned `if / else if / else` ladders with single-line braced bodies.
- Class is `class Solution{N}`, default (package-private) access, package
  matches the directory path.
- One-line `// Approach: <description>` comment above the class.

## Building and running

From the repo root:

```bash
cd java && mvn -B compile
```

JDK 17+ is required. There are no runtime dependencies. CI runs the same
command on every push and PR.

There are no tests in the repo; the build verifies compilation only.

## Adding a new solution

When adding `SolutionN.java` to an existing problem (where the directory
already has `Solution1`, etc.), increment `N` rather than overwriting.

When adding a brand-new problem, create the snake_case directory under the
appropriate `<provider>/<tier-or-pattern>/`, add a `README.md` (see any
existing one for the template), and add `Solution1.java` with `package` line
matching the directory.

## Difficulty badges

Five levels, used in each problem's README via shields.io badges:

- `warm-up` — elementary, FizzBuzz-tier
- `easy` — genuine easy
- `medium`, `hard`, `very-hard` — as labeled by the source

Defaults from source tier are applied at migration time but can be overridden
per problem.
````

- [ ] **Step 4: Final `mvn -B compile`**

```bash
cd java && mvn -B compile && cd ..
```

Expected: `BUILD SUCCESS`. Confirms the cleanup didn't accidentally break anything.

- [ ] **Step 5: Verify total file count makes sense**

```bash
find java/src/main/java -name '*.java' | wc -l
```

Expected: matches the legacy total (around 476). If it differs from the sum of the three migration counts in Tasks 6-8, investigate the delta before committing.

- [ ] **Step 6: Verify the migration script's own tests still pass**

```bash
cd scripts && python3 -m unittest test_migrate -v && cd ..
```

Expected: 18 tests pass. Confirms the script is in a known-good state in case it ever needs to be re-run.

- [ ] **Step 7: Commit cleanup**

```bash
git add -A
git commit -m "chore: remove empty legacy provider dirs and update CLAUDE.md"
```

- [ ] **Step 8: Push and verify CI**

```bash
git push origin main
```

Then open `https://github.com/thekaveh/tech-interview-questions/actions` in a browser and confirm the `java-build` workflow runs and goes green. If red, drill into the failed step's logs and report back.

---

## Self-review

- ✅ **Spec coverage:** Every spec section (layout, file shape, pom.xml, CI, top-level README, LICENSE, attribution, migration mechanics) has at least one task that implements it. Out-of-scope items (tests per problem, content backfill, language-agnostic `problems/`) are not in the plan, matching the spec.
- ✅ **No placeholders:** Every step has actual code or a concrete command. No "TODO" or "implement appropriately."
- ✅ **Type consistency:** `transform_algoexpert`, `transform_codesignal`, `transform_educative` signatures match between Task 3 (definition) and Task 4 (orchestrator). `new_path_for`, `package_for`, `readme_for` signatures consistent across Task 2 tests and Task 4 use.
- ✅ **Reversibility:** Each migration commit (Tasks 6, 7, 8) is a clean unit that can be reverted with `git revert <hash>` if a downstream issue is found later.
- ✅ **Verification before completion:** Tasks 6-9 each run `mvn -B compile` and Task 9 pushes to verify CI. Build failures have explicit diagnose-and-retry instructions.
