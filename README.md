# Tech Interview Questions

[![build](https://github.com/thekaveh/tech-interview-questions/actions/workflows/java-build.yml/badge.svg)](https://github.com/thekaveh/tech-interview-questions/actions/workflows/java-build.yml)

A personal collection of solved coding-interview problems from AlgoExpert,
CodeSignal, and Educative. Solutions are my own work; problem statements in
each `README.md` are paraphrased in my own words.

## 1. Layout

```
java/                              ← Java solutions (active)
  src/main/java/
    algoexpert/{easy,medium,hard,veryhard}/<problem_snake>/
    codesignal/{intro,thecore}/<problem_snake>/
    educative/patterns/<pattern_snake>/<problem_snake>/
python/                            ← reserved for future
```

Each `<problem_snake>/` directory contains a `README.md` (problem summary,
difficulty badge, complexity table) and one or more `SolutionN.java` files,
where the number denotes attempt order. The `// Approach:` comment in each
file names the technique used.

## 2. Building

```
cd java
mvn -B compile
```

Requires JDK 17+. There are no runtime dependencies; the build only verifies
that all solutions compile.

## 3. Difficulty badges

- ![warmup](https://img.shields.io/badge/-warm--up-green) — elementary, FizzBuzz-tier
- ![easy](https://img.shields.io/badge/-easy-yellowgreen)
- ![medium](https://img.shields.io/badge/-medium-yellow)
- ![hard](https://img.shields.io/badge/-hard-orange)
- ![very-hard](https://img.shields.io/badge/-very--hard-red)

The badge value defaults from the source tier but is labeled honestly per
problem — some "easy"-tier problems are really warm-ups.

## 4. Migration tool

`scripts/migrate.py` is the one-shot tool that reshaped the legacy
provider-rooted snippet tree into the current Maven-based layout. It is
kept in-tree as documentation of how the move was performed. Its unit
tests live alongside it:

```
python3 -m unittest discover -s scripts -p 'test_*.py'
```

## 5. License

[MIT](./LICENSE)
