# Merge Sorted Arrays

![Difficulty](https://img.shields.io/badge/difficulty-very--hard-red)
**Source:** AlgoExpert

## 1. Problem

Given a list of sorted integer arrays, merge them all into a single sorted array and return it. Each input array is already sorted, and the total count of arrays and their combined lengths can be large.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Min-heap of (row, col) index pairs with Idx2D class | O(n log k) | O(k) |
| Solution2 | Min-heap of int[] index pairs | O(n log k) | O(k) |
