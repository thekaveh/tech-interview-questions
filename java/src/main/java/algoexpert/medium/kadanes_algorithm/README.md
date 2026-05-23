# Kadane's Algorithm

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given an array of integers (which may include negative numbers), find the maximum sum of any contiguous subarray. The array is guaranteed to have at least one element, and the subarray must contain at least one element.

## 2. Solutions

| File      | Approach                              | Time  | Space |
| --------- | ------------------------------------- | ----- | ----- |
| Solution1 | Brute force triple nested loop        | O(n³) | O(1)  |
| Solution2 | Kadane's single-pass running max      | O(n)  | O(1)  |
| Solution3 | Kadane's with two-element array state | O(n)  | O(1)  |
