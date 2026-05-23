# Remove Islands

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given a 2-D matrix of 0s and 1s, remove all "islands" — connected components of 1s that do not touch the border of the matrix — by setting them to 0. Connected components that reach any border cell are preserved.

## 2. Solutions

| File      | Approach                                                           | Time   | Space  |
| --------- | ------------------------------------------------------------------ | ------ | ------ |
| Solution1 | DFS to label connected components, then zero non-border components | O(r·c) | O(r·c) |
