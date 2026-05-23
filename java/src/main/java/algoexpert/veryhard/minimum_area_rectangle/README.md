# Minimum Area Rectangle

![Difficulty](https://img.shields.io/badge/difficulty-very--hard-red)
**Source:** AlgoExpert

## 1. Problem

Given a set of 2D points, find the minimum area of any axis-aligned rectangle that can be formed by choosing four of those points as its corners. Return 0 if no rectangle can be formed.

## 2. Solutions

| File      | Approach                                                             | Time  | Space |
| --------- | -------------------------------------------------------------------- | ----- | ----- |
| Solution1 | Point-set lookup: for each diagonal pair check the other two corners | O(n²) | O(n)  |
