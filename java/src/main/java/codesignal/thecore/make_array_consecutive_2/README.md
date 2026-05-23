# Make Array Consecutive 2

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

Given an array of distinct integers, return how many numbers you would need to add so that the array forms a consecutive sequence from its minimum to its maximum value.

## 2. Solutions

| File      | Approach                                         | Time       | Space |
| --------- | ------------------------------------------------ | ---------- | ----- |
| Solution1 | Sort then sum the gaps between adjacent elements | O(n log n) | O(1)  |
| Solution2 | Sort then return (max − min + 1 − n) directly    | O(n log n) | O(1)  |
