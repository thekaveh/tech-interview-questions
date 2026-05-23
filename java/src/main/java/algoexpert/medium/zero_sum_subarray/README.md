# Zero Sum Subarray

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given an array of integers, determine whether any contiguous subarray sums to zero. Return true if such a subarray exists, false otherwise. A subarray must contain at least one element.

## 2. Solutions

| File      | Approach                                                      | Time  | Space |
| --------- | ------------------------------------------------------------- | ----- | ----- |
| Solution1 | Brute force: try all (lo, hi) pairs                           | O(n²) | O(1)  |
| Solution2 | Prefix sum set: repeated prefix sum implies zero-sum subarray | O(n)  | O(n)  |
