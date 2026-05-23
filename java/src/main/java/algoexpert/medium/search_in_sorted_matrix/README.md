# Search In Sorted Matrix

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given an n×m matrix where each row and each column is sorted in ascending order, and a target value, return the [row, col] position of the target. Return [-1, -1] if the target is not present.

## 2. Solutions

| File      | Approach                                           | Time     | Space |
| --------- | -------------------------------------------------- | -------- | ----- |
| Solution1 | Row-by-row linear scan with early break            | O(n·m)   | O(1)  |
| Solution2 | Start top-right, eliminate row or column each step | O(n + m) | O(1)  |
