# Python solutions

Stub tree for future Python ports of selected problems. Mirrors the
`java/` layout: `src/<provider>/<tier>/<problem_snake>/solution_<N>.py`.

Currently a single example (Two Number Sum) is here to prove the layout
and test wiring work. Add more as desired; each new problem follows the
same shape as in [`../CLAUDE.md`](../CLAUDE.md) §3, translated to
Python idioms.

## 1. Layout

```text
python/
  pyproject.toml
  src/<provider>/<tier>/<problem_snake>/solution_<N>.py
  tests/<provider>/<tier>/<problem_snake>/test_solution_<N>.py
```

## 2. Running the tests

From this directory:

```bash
python3 -m pytest
```

Requires Python 3.10+ and `pytest` installed (`pip install pytest`).

## 3. Conventions

- One module per solution attempt, named `solution_1.py`,
  `solution_2.py`, …
- Module exposes a top-level function whose name matches the problem
  verb (e.g. `two_number_sum(...)`).
- One `# Approach: ...` comment at the top of each solution module,
  matching the Java tree's convention.
- Tests in `tests/` mirror the source tree; each `test_solution_<N>.py`
  imports the matching solution module and asserts the canonical
  example.
