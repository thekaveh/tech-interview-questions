# Number Of Ways To Traverse Graph

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given an integer grid of width `C` and height `R`, count the number of distinct paths from the top-left corner to the bottom-right corner when you may only move right or down at each step.

## 2. Solutions

| File      | Approach                                | Time       | Space    |
| --------- | --------------------------------------- | ---------- | -------- |
| Solution1 | Naive recursion                         | O(2^(C+R)) | O(C + R) |
| Solution2 | Top-down recursion with 2-D memoization | O(C · R)   | O(C · R) |
| Solution3 | Bottom-up DP table                      | O(C · R)   | O(C · R) |
