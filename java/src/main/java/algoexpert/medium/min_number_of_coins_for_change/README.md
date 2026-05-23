# Min Number Of Coins For Change

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given a target amount `n` and an array of coin denominations, return the minimum number of coins needed to make exact change for `n`. You may use each denomination an unlimited number of times; return -1 if no combination can produce the exact amount.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Naive recursion (include/exclude each denomination) | O(2^(n+d)) | O(n + d) |
| Solution2 | Top-down recursion with 2-D memoization | O(n · d) | O(n · d) |
| Solution3 | Bottom-up DP table | O(n · d) | O(n · d) |
