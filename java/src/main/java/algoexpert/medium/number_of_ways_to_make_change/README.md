# Number Of Ways To Make Change

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given a target amount and an array of distinct coin denominations, count the total number of ways to make exact change using any number of each denomination. The order of coins does not matter; each combination is counted once.

## 2. Solutions

| File      | Approach                                            | Time       | Space    |
| --------- | --------------------------------------------------- | ---------- | -------- |
| Solution1 | Naive recursion (include/exclude each denomination) | O(2^(n+d)) | O(n + d) |
| Solution2 | Top-down recursion with 2-D memoization             | O(n · d)   | O(n · d) |
| Solution3 | Bottom-up DP table                                  | O(n · d)   | O(n · d) |
