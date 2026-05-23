# Sort Stack

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given a stack (represented as an ArrayList), sort it in ascending order with the smallest value on top, using only stack operations. No auxiliary data structures other than additional stacks/recursion are permitted.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Iterative: extract each element and insert in sorted order | O(n²) | O(n) |
| Solution2 | Recursive: pop top, sort remainder, insert at correct position | O(n²) | O(n) |
