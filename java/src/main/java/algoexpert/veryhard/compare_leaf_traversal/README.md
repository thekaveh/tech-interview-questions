# Compare Leaf Traversal

![Difficulty](https://img.shields.io/badge/difficulty-very--hard-red)
**Source:** AlgoExpert

## 1. Problem

Given two binary trees, determine whether the sequence of leaf node values (read left to right) is identical between the two trees. Internal node values and tree shapes may differ.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Collect all leaves from each tree then compare lists | O(n+m) | O(n+m) |
| Solution2 | Two synchronized iterative DFS stacks, compare leaf by leaf | O(n+m) | O(h1+h2) |
