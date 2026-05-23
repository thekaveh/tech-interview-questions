# Maximum Sum Subarray Of Size K

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** Educative

## 1. Problem

Given an array of integers and a positive integer k, find the maximum sum of any contiguous subarray of exactly k elements.

## 2. Solutions

| File      | Approach                                                                                                   | Time | Space |
| --------- | ---------------------------------------------------------------------------------------------------------- | ---- | ----- |
| Solution1 | Fixed-size sliding window maintaining a running sum, sliding by subtracting the element leaving the window | O(n) | O(1)  |
