# Documentation

Long-form documentation for the repo lives here. Per-problem READMEs sit
next to their solution code under `java/src/main/java/` and are not
indexed from this directory.

## 1. Layout

```
docs/
  superpowers/
    specs/    ← design specifications produced during brainstorming
    plans/    ← implementation plans derived from specs
```

## 2. Conventions

- One file per discrete document. Filenames are dated:
  `YYYY-MM-DD-<topic>-<kind>.md` (e.g. `2026-05-22-repo-restructure-design.md`).
- Every document uses hierarchical numbered section headings
  (`## 1. ...`, `### 1.1. ...`) so structure is uniform across the repo.
- Specs describe **what** to build and **why**; plans describe **how**
  to build it, step by step. Specs are the primary artifact; plans are
  derived.

## 3. Current documents

| Path | Kind | Description |
|---|---|---|
| [`superpowers/specs/2026-05-22-repo-restructure-design.md`](./superpowers/specs/2026-05-22-repo-restructure-design.md) | Spec | The design that drove the move from the legacy snippet tree to the current Maven-based layout. |
| [`superpowers/plans/2026-05-22-repo-restructure.md`](./superpowers/plans/2026-05-22-repo-restructure.md) | Plan | The nine-task implementation plan executed against that spec. |
