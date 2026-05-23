# Union Find

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Implement a Union-Find (Disjoint Set Union) data structure supporting `createSet`, `find` (returns the root/representative of a set), and `union` (merges two sets). The structure must correctly return null for unknown elements in `find`.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Basic Union-Find with HashMap parents, no rank | O(n) find/union | O(n) |
| Solution2 | Union by size (weighted union) with HashMap | O(log n) find/union | O(n) |
| Solution3 | Union by size with path compression (path halving) | O(α(n)) find/union | O(n) |
