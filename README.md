# Tech Interview Questions

[![build](https://github.com/thekaveh/tech-interview-questions/actions/workflows/java-build.yml/badge.svg)](https://github.com/thekaveh/tech-interview-questions/actions/workflows/java-build.yml)

A personal collection of solved coding-interview problems from AlgoExpert,
CodeSignal, and Educative. Solutions are my own work; problem statements in
each `README.md` are paraphrased in my own words.

## 1. Browse problems

Open the [online problem catalog](https://thekaveh.github.io/tech-interview-questions/PROBLEMS.html)
or the [problem index](PROBLEMS.md). Choose a provider and tier, then open a
problem to read its paraphrased statement and compare solution approaches with
their time and space complexity.

For a first example, read [Two Number Sum](java/src/main/java/algoexpert/easy/two_number_sum/README.md).
Its table compares brute force, sorting with binary search, and two pointers.
Open its [Java implementations](https://github.com/thekaveh/tech-interview-questions/tree/main/java/src/main/java/algoexpert/easy/two_number_sum)
to study each approach. Browsing
requires no local build; the Python tree currently contains one example port.

## 2. Build locally

Install Git, a JDK **17 or newer**, and Maven before running the commands below.
Make sure `java` and `mvn` are available in your shell. From a new checkout:

```bash
git clone https://github.com/thekaveh/tech-interview-questions.git
cd tech-interview-questions
```

From the checkout root, build the Java project:

```bash
(cd java && mvn -B verify)
```

A successful run ends with Maven's `BUILD SUCCESS`. It compiles every Java
solution and runs the JUnit smoke test that loads each `Solution{N}` class through
reflection. This checks compilation and class loading, not the correctness of
every algorithm. See the [Python guide](python/README.md) for its separate test path.

## 3. Inventory

| Provider   | Problems | Solutions |
| ---------- | -------: | --------: |
| AlgoExpert |      168 |       316 |
| CodeSignal |      102 |       150 |
| Educative  |        8 |         9 |
| **Total**  |  **278** |   **475** |

## 4. Layout

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

## 5. Difficulty badges

- ![warmup](https://img.shields.io/badge/-warm--up-green) — elementary, FizzBuzz-tier
- ![easy](https://img.shields.io/badge/-easy-yellowgreen)
- ![medium](https://img.shields.io/badge/-medium-yellow)
- ![hard](https://img.shields.io/badge/-hard-orange)
- ![very-hard](https://img.shields.io/badge/-very--hard-red)

The badge defaults from the source tier but is labeled honestly per
problem — some "easy"-tier problems are really warm-ups.

## 6. Extend the collection

External contributions are not actively solicited. Forks and future additions
should follow the public [contributor and style guide](https://github.com/thekaveh/tech-interview-questions/blob/main/CONTRIBUTING.md),
which covers layout, solution naming, code style, catalog regeneration and checks.

## 7. License

[MIT license](https://github.com/thekaveh/tech-interview-questions/blob/main/LICENSE)
