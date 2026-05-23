# Tech Interview Questions

[![build](https://github.com/thekaveh/tech-interview-questions/actions/workflows/java-build.yml/badge.svg)](https://github.com/thekaveh/tech-interview-questions/actions/workflows/java-build.yml)

A personal collection of solved coding-interview problems from AlgoExpert,
CodeSignal, and Educative. Solutions are my own work; problem statements in
each `README.md` are paraphrased in my own words.

## 1. Counts

| Provider   | Problems | Solutions |
| ---------- | -------: | --------: |
| AlgoExpert |      168 |       316 |
| CodeSignal |      102 |       150 |
| Educative  |        8 |         9 |
| **Total**  |  **278** |   **475** |

Full browsable index: [PROBLEMS.md](./PROBLEMS.md).

## 2. Layout

```text
java/                              ← Java solutions (active)
  src/main/java/
    algoexpert/{easy,medium,hard,veryhard}/<problem>/
    codesignal/{intro,thecore}/<problem>/
    educative/patterns/<pattern>/<problem>/
python/                            ← stub for future Python ports
scripts/                           ← end-state verification + index generator
```

Each `<problem>/` directory contains a `README.md` (problem summary,
difficulty badge, complexity table) and one or more `SolutionN.java`
files where the number denotes attempt order.

## 3. Building

```bash
cd java && mvn -B verify
```

Requires JDK 17+. The build compiles every solution and runs the JUnit
smoke test that loads each `Solution{N}` class via reflection.

## 4. Difficulty badges

- ![warmup](https://img.shields.io/badge/-warm--up-green) — elementary, FizzBuzz-tier
- ![easy](https://img.shields.io/badge/-easy-yellowgreen)
- ![medium](https://img.shields.io/badge/-medium-yellow)
- ![hard](https://img.shields.io/badge/-hard-orange)
- ![very-hard](https://img.shields.io/badge/-very--hard-red)

The badge defaults from the source tier but is labeled honestly per
problem — some "easy"-tier problems are really warm-ups.

## 5. Adding a problem

See [CONTRIBUTING.md](./CONTRIBUTING.md) for the conventions, and
[CLAUDE.md](./CLAUDE.md) for the full house-style reference.

## 6. Browse online

GitHub Pages is configured (`_config.yml` + `.github/workflows/pages.yml`).
Enable it once in repo Settings → Pages → Source: **GitHub Actions**, then
each push deploys a Jekyll site rendering this README and the per-problem
catalog.

## 7. License

[MIT](./LICENSE)
