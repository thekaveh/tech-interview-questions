# Find Three Largest Numbers

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** AlgoExpert

## 1. Problem

An integer array with at least three elements is provided; return the three largest values in sorted ascending order without modifying the original array. Duplicate values may exist in the input. The output must always be a three-element array.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Min-heap of size 3 | O(n log 3) | O(1) |
| Solution2 | Max-heap, extract top 3 | O(n log n) | O(n) |
