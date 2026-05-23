# Contributing

This is a personal portfolio of solved interview problems, so external
contributions aren't actively solicited. The conventions below exist so
that future me — or anyone forking the repo — can extend it consistently.

## 1. Layout

See [CLAUDE.md](./CLAUDE.md) for the canonical reference on directory
structure, file naming, house code style, and the difficulty-badge
scheme.

## 2. Adding a new solution to an existing problem

1. Increment `N` to the next integer and add `Solution{N}.java` next to
   the existing ones. The `package` line and class name must match the
   directory.
2. Add a `// Approach: <2-5 word description>` comment immediately above
   the class declaration.
3. Add a new row to the problem's `README.md` solutions table with
   `Solution{N}`, the approach, time complexity, and space complexity.

## 3. Adding a brand-new problem

1. Pick the provider, tier, and a snake_case problem name. Create the
   directory under `java/src/main/java/<provider>/<tier>/<problem>/`.
2. Drop in `Solution1.java` following the shape in CLAUDE.md §3.
3. Drop in `README.md` mirroring any existing problem README — title,
   difficulty badge, `**Source:**` line, then `## 1. Problem` and
   `## 2. Solutions`.
4. Regenerate the top-level problem index:
   ```bash
   python3 scripts/generate_problem_index.py
   ```
5. Run the invariants check:
   ```bash
   bash scripts/verify_final.sh
   ```

## 4. Adding a new language tree

The layout is intentionally language-prefixed (`java/`, `python/`, …).
A new language should be a sibling directory at the repo root with its
own build configuration, mirroring the provider/tier/problem layout of
`java/src/main/java/`.

## 5. CI

`scripts/verify_final.sh` runs on every push and PR via
`.github/workflows/java-build.yml`. It must stay green; anything else
blocks merging.
