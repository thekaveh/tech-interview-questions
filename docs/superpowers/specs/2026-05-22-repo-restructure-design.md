# Repo Restructure Design

**Date:** 2026-05-22
**Status:** Implemented
**Author:** Kaveh Razavi

## 1. Goal

Restructure this personal interview-solutions repo from a flat collection of
paste-ready snippets into a buildable, portfolio-credible Java project, while
preserving the existing per-provider organization and leaving the door open
for solutions in other languages.

## 2. Constraints (decided up front)

- **Audience:** portfolio-credible to recruiters who land on it cold, but
  organized by provider because that mirrors how the solutions were actually
  produced.
- **Solution bodies are not refactored.** The author's solution style (`var`
  locals, terse identifiers, `import java.util.*`, single-line braced
  `if`/`else if` ladders) is preserved verbatim. Surrounding scaffolding —
  `package` declaration, optional class wrapper for CodeSignal — may change.
- **Multi-language door stays open.** Layout treats Java as one of several
  future language trees, not as "the" tree.
- **No tests yet.** The repo currently has none; the build verifies
  compilation only. Test scaffolding is explicitly not added.
- **No trivially-easy problems are removed.** They are labeled honestly via
  a difficulty badge in each problem's README instead.

## 3. Target directory layout

```
tech-interview-questions/
├── README.md                          ← rewritten landing page
├── LICENSE                            ← MIT
├── CLAUDE.md                          ← updated to match new layout
├── .gitignore, .trunk/, .vscode/      ← preserved
├── .github/
│   └── workflows/
│       └── java-build.yml             ← runs `mvn -B compile` on push/PR
├── docs/
│   └── superpowers/specs/             ← this design doc and future ones
├── java/
│   ├── pom.xml
│   └── src/main/java/
│       ├── algoexpert/
│       │   ├── easy/<problem_snake>/
│       │   ├── medium/<problem_snake>/
│       │   ├── hard/<problem_snake>/
│       │   └── veryhard/<problem_snake>/
│       ├── codesignal/
│       │   ├── intro/<problem_snake>/
│       │   └── thecore/<problem_snake>/
│       └── educative/
│           └── patterns/
│               └── <pattern_snake>/<problem_snake>/
└── python/                            ← reserved (does not exist yet)
```

Each `<problem_snake>/` directory contains a `README.md` plus one or more
`Solution{N}.java` files.

### 3.1. Naming transforms

- Top-level `algoexpert.io/`, `codesignal.com/`, `educative.io/` lose their
  `.io`/`.com` suffix when they become Java packages.
- `very-hard` → `veryhard`; `the-core` → `thecore`. Tier/section names are
  flattened to single-word Java identifiers.
- Kebab-case problem and pattern names become snake_case:
  `two-number-sum` → `two_number_sum`, `sliding-window` → `sliding_window`.
- `educative.io/patterns-for-coding-questions/` collapses to
  `educative/patterns/` (the "for-coding-questions" segment is redundant
  given the repo's name).
- CodeSignal filenames `solution-1.java` become `Solution1.java`.
- The one camelCase outlier `codesignal.com/intro/isDigit/` becomes
  `codesignal/intro/is_digit/`.

## 4. Per-problem file shape

### 4.1. `README.md`

Compact stub, ~20 lines. Auto-generated with `TODO` placeholders that the
author fills in over time. Filling them in is not a blocker for the
restructure itself.

```markdown
# Two Number Sum

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** AlgoExpert

Given an array of integers and a target sum, return any two numbers from the
array that add to the target. Each input has at most one valid pair.

**Example**
```
A = [3, 5, -4, 8, 11, 1, -1, 6], S = 10
→ [11, -1]
```

**Solutions**
| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Brute force nested loop | O(n²) | O(1) |
| Solution2 | Sort + two pointers | O(n log n) | O(1) |
| Solution3 | Hash set, single pass | O(n) | O(n) |
```

### 4.2. Difficulty badge values

- `warm-up` (green) — FizzBuzz-tier
- `easy` (yellowgreen) — genuine easy
- `medium` (yellow)
- `hard` (orange)
- `very-hard` (red)

Default mapping at migration time:

| Source location | Default badge |
|---|---|
| algoexpert/easy | warm-up |
| algoexpert/medium | medium |
| algoexpert/hard | hard |
| algoexpert/veryhard | very-hard |
| codesignal/intro | warm-up |
| codesignal/thecore | easy |
| educative/patterns | easy |

The default is a starting point; the author may override per problem when
filling in the README.

### 4.3. `Solution{N}.java`

Three additions to existing files:

1. `package <full.dotted.path>;` declaration matching the directory.
2. One-line `// Approach: <description>` comment immediately above the `class`
   line. Auto-migration inserts `// Approach: TODO` as a placeholder.
3. For CodeSignal files only: wrap the bare `int solution(...)` function in
   `class Solution{N} { static int solution(...) { ... } }` and add
   `import java.util.*;`. The function body is byte-identical to the
   pre-migration version.

Class names stay `Solution1`, `Solution2`, … Default (package-private)
access. Package disambiguates across problems, so `Solution1` is fine to
reuse in every problem's package.

### 4.4. Example: AlgoExpert solution immediately after migration

The migration step inserts a `// Approach: TODO` placeholder. The author
fills it in later.

```java
package algoexpert.easy.two_number_sum;
import java.util.*;

// Approach: TODO.
class Solution1 {
    public static int[] twoNumberSum(int[] A, int S) {
        int N = A.length;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (A[i] + A[j] == S) {
                    return new int[] { A[i], A[j] };
                }
            }
        }
        return new int[0];
    }
}
```

### 4.5. Example: AlgoExpert solution after the author fills in the placeholder

```java
package algoexpert.easy.two_number_sum;
import java.util.*;

// Approach: brute force nested loop.
class Solution1 {
    public static int[] twoNumberSum(int[] A, int S) {
        int N = A.length;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (A[i] + A[j] == S) {
                    return new int[] { A[i], A[j] };
                }
            }
        }
        return new int[0];
    }
}
```

### 4.6. Example: CodeSignal solution immediately after migration

```java
package codesignal.intro.adjacent_elements_product;
import java.util.*;

// Approach: TODO.
class Solution1 {
    static int solution(int[] A) {
        var N = A.length;
        var R = Integer.MIN_VALUE;
        for (var i = 1; i < N; i++) {
            var T = A[i - 1] * A[i];
            R = Math.max(R, T);
        }
        return R;
    }
}
```

## 5. Maven build

`java/pom.xml`:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0">
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

Notes:
- **JDK 17** — LTS, matches the local development environment.
- **No dependencies.** Solutions are stdlib-only.
- **`README.md` files alongside `.java` files are ignored by the build.**
  Maven compiles only `*.java` from `src/main/java/` and treats only
  `src/main/resources/` as a resource directory. The README files sit in
  the source tree purely as documentation; they are neither compiled nor
  packaged.
- `groupId` is independent of the source package names. Source packages stay
  short and readable (`algoexpert.easy.two_number_sum`, not
  `com.thekaveh.algoexpert.easy.two_number_sum`).

## 6. CI

`.github/workflows/java-build.yml`:

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

A build-status badge is added to the top-level `README.md`.

## 7. Top-level README

Rewritten to be a concise landing page that does five things: states what
the repo is, declares that solutions are the author's work and problem
statements are paraphrased (covers attribution), shows the directory layout,
documents the build command, and explains the difficulty badge scheme.

```markdown
# Tech Interview Questions

[![build](https://github.com/thekaveh/tech-interview-questions/actions/workflows/java-build.yml/badge.svg)](https://github.com/thekaveh/tech-interview-questions/actions/workflows/java-build.yml)

A personal collection of solved coding-interview problems from AlgoExpert,
CodeSignal, and Educative. Solutions are my own work; problem statements in
each `README.md` are paraphrased in my own words.

## Layout

(directory tree as in this design)

Each `<problem>/` directory contains a `README.md` and one or more
`SolutionN.java` files, where the number denotes attempt order. The
`// Approach:` comment in each file names the technique used.

## Building

cd java
mvn -B compile

Requires JDK 17+. There are no runtime dependencies; the build only
verifies all solutions compile.

## Difficulty badges

(badge legend)

## License

[MIT](./LICENSE)
```

## 8. LICENSE

MIT license, 2026, holder "Kaveh Razavi."

## 9. Attribution policy

- Provider directory names (`algoexpert/`, `codesignal/`, `educative/`) are
  retained as descriptive (nominative) trademark use.
- Problem statements in each README are paraphrased in the author's own
  words; provider problem text is never copied verbatim.
- No source URLs are included (per user preference).
- The top-level README's opening paragraph states the paraphrasing policy.
  No separate `NOTICE.md` is added.

## 10. Migration mechanics

The implementation will execute as a sequence of commits, each producing a
working tree that still compiles (after the first commit that introduces
`pom.xml`):

1. **Bootstrap commit.** Add `java/pom.xml`, `LICENSE`, the rewritten
   top-level `README.md`, `.github/workflows/java-build.yml`, and the
   `java/src/main/java/` directory skeleton. No source files moved yet.
2. **AlgoExpert migration commit.** `git mv` every file from
   `algoexpert.io/<tier>/<problem>/SolutionN.java` to
   `java/src/main/java/algoexpert/<tier_clean>/<problem_snake>/SolutionN.java`,
   prepend `package` declaration and `// Approach: TODO` comment to each.
   Generate `README.md` per problem directory from the template. Verify
   `mvn -B compile` passes.
3. **CodeSignal migration commit.** Same as above, with the additional
   bare-function-to-class wrap and `import java.util.*;` addition. Verify
   compile.
4. **Educative migration commit.** Same as the AlgoExpert step plus the
   `patterns-for-coding-questions` → `patterns` path collapse. Verify
   compile.
5. **Cleanup commit.** Delete now-empty `algoexpert.io/`, `codesignal.com/`,
   `educative.io/` top-level directories. Update `CLAUDE.md` to reflect the
   new layout. Final `mvn -B compile` verification.

All migrations use `git mv` to preserve per-file history.

## 11. Out of scope (deferred)

These were considered and explicitly excluded from this design:

- **JUnit tests per problem.** Would turn the restructure into a months-long
  content backlog. Test scaffolding is also excluded — it implies tests are
  coming.
- **Hard removal or archive of trivially-easy problems.** Replaced by the
  honest-labeling difficulty badge.
- **A language-agnostic top-level `problems/` directory** holding shared
  READMEs. Deferred until a second language tree actually exists; the
  current per-language duplication is acceptable given there is only one
  language tree today.
- **Filling in `Approach: TODO` and `README.md` `TODO` placeholders.**
  Mechanical migration leaves these as placeholders. The author fills them
  in over time as a separate ongoing effort.
- **Java linter / formatter.** Matches the existing "Java is not linted"
  stance. Trunk's `prettier` + `markdownlint` continue to handle markdown.

## 12. Open questions

None at design time. Any deferred decisions (e.g., exact difficulty-badge
override per problem) are intentionally individual judgment calls the
author makes when filling in TODO placeholders.
