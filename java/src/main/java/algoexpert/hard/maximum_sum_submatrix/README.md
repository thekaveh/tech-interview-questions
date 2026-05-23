# Maximum Sum Submatrix

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given an integer matrix and a side length `size`, find the contiguous square sub-matrix of that size whose elements have the greatest sum. Return that sum.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Brute force sliding window over all positions | O(r·c·size²) | O(1) |
| Solution2 | 2-D prefix sums for O(1) sub-matrix queries | O(r·c) | O(r·c) |
