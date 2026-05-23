# Maximize Expression

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given an array of integers, find the maximum value of the expression A[i] - A[j] + A[k] - A[l] where i < j < k < l. If fewer than four elements exist, return 0.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Four nested loops brute force | O(n⁴) | O(1) |
| Solution2 | Four DP passes (prefix max for each term) | O(n) | O(n) |
