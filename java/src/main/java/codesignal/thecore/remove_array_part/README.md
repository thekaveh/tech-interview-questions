# Remove Array Part

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

Given an array and two indices lo and hi (inclusive), remove all elements between those indices and return the shortened array with the remaining elements preserving their original order.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Manually copy elements before lo and after hi into a new array | O(n) | O(n) |
| Solution2 | IntStream filter keeping only indices outside [lo, hi] | O(n) | O(n) |
