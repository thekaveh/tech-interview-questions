# Three Number Sum

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given an array of integers and a target sum, find all triplets of distinct elements that add up to the target. Return all such triplets as a list of sorted three-element arrays, with the overall list sorted in ascending order.

## 2. Solutions

| File      | Approach                                                      | Time  | Space |
| --------- | ------------------------------------------------------------- | ----- | ----- |
| Solution1 | Sort + brute force triple nested loop                         | O(n³) | O(n)  |
| Solution2 | Sort + outer loop with inner two-pointer                      | O(n²) | O(n)  |
| Solution3 | Sort + outer loop with inner two-pointer (combined loop vars) | O(n²) | O(n)  |
