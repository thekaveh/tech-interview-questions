# Branch Sums

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** AlgoExpert

## 1. Problem

A binary tree is provided; compute the sum of node values along every root-to-leaf path and return those sums as a list ordered from leftmost to rightmost branch. Each path starts at the root and ends at a leaf node. The tree may be unbalanced, and each node holds a single integer value.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Recursive DFS, isLeaf helper | O(n) | O(n) |
| Solution2 | Recursive DFS, inline leaf check | O(n) | O(n) |
