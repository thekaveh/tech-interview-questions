# Rectangle Mania

![Difficulty](https://img.shields.io/badge/difficulty-very--hard-red)
**Source:** AlgoExpert

## 1. Problem

Given a list of 2D coordinates, count the number of axis-aligned rectangles that can be formed using four of those points as corners. Rectangles of any size count, and the same four points always define exactly one rectangle.

## 2. Solutions

| File      | Approach                                                                               | Time  | Space |
| --------- | -------------------------------------------------------------------------------------- | ----- | ----- |
| Solution1 | Point-set lookup: for each ordered pair of non-collinear points check opposite corners | O(n²) | O(n)  |
