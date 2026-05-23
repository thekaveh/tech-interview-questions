# Solve Sudoku

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given a partially filled 9×9 Sudoku board (0 represents empty cells), fill in the board so that every row, column, and 3×3 box contains each digit 1–9 exactly once. The input is guaranteed to have exactly one valid solution.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Backtracking with row/column/box validity checks | O(9^m) where m = empty cells | O(m) |
