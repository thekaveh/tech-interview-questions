# Python solutions

Stub tree for future Python ports of selected problems. Mirrors the
`java/` layout: `src/<provider>/<tier>/<problem_snake>/solution_<N>.py`.

Currently a single example (Two Number Sum) is here to prove the layout
and test wiring work. Add more as desired; each new problem follows the
public [solution-shape conventions](https://github.com/thekaveh/tech-interview-questions/blob/main/CONTRIBUTING.md#1-layout-and-solution-shape),
translated to Python idioms.

## 1. Layout

```text
python/
  pyproject.toml
  src/<provider>/<tier>/<problem_snake>/solution_<N>.py
  tests/<provider>/<tier>/<problem_snake>/test_solution_<N>.py
```

## 2. Running the tests

Install Python 3.10+ before testing. From the repository root, create an isolated
environment and install `pytest`, then enter the Python project:

```bash
python3 -m venv /tmp/tech-interview-python-venv
. /tmp/tech-interview-python-venv/bin/activate
python3 -m pip install pytest
cd python
python3 -m pytest
```

The current example's tests should pass. These tests cover the single Python port,
not the Java collection.

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
