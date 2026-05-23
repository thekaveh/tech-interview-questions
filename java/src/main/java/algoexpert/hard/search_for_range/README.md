# Search For Range

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given a sorted array of integers that may contain duplicates and a target value, find the first and last index at which the target appears. If the target is not in the array, return [-1, -1]. The solution must run in O(log n).

## 2. Solutions

| File      | Approach                                              | Time     | Space    |
| --------- | ----------------------------------------------------- | -------- | -------- |
| Solution1 | Two binary searches (iterative) biased left and right | O(log n) | O(1)     |
| Solution2 | Two binary searches (recursive) biased left and right | O(log n) | O(log n) |
