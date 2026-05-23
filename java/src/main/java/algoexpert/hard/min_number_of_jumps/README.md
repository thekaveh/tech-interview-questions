# Min Number Of Jumps

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given an array where each element represents the maximum jump length from that position, find the minimum number of jumps needed to reach the last index starting from the first index.

## 2. Solutions

| File      | Approach                                             | Time  | Space |
| --------- | ---------------------------------------------------- | ----- | ----- |
| Solution1 | Bottom-up DP (forward pass updating reachable cells) | O(n²) | O(n)  |
| Solution2 | Top-down memoized recursion                          | O(n²) | O(n)  |
