# Matrix Elements Sum

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** CodeSignal

## 1. Problem

Given a hotel floor plan matrix where 0 indicates a room that cannot be used, sum all reachable room values — a 0 in any row blocks all rooms below it in the same column.

## 2. Solutions

| File      | Approach                                    | Time    | Space |
| --------- | ------------------------------------------- | ------- | ----- |
| Solution1 | Row-major scan with per-column blocked flag | O(R\*C) | O(C)  |
| Solution2 | Column-major scan, break on zero per column | O(R\*C) | O(1)  |
