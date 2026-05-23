# Staircase Traversal

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given a staircase with `H` steps and a maximum jump size `S`, count the number of distinct ways to reach the top. At each position you may take 1 to S steps; the answer can be very large but is returned as a plain integer.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Naive recursion | O(S^H) | O(H) |
| Solution2 | Top-down recursion with memoization | O(H · S) | O(H) |
| Solution3 | Bottom-up DP table | O(H · S) | O(H) |
