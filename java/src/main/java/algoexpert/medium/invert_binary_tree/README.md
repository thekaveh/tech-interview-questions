# Invert Binary Tree

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given a binary tree, invert it in place so that every node's left and right children are swapped. The operation must be applied recursively to all nodes, and the root of the modified tree is returned (or the tree is mutated in place).

## 2. Solutions

| File      | Approach                       | Time | Space |
| --------- | ------------------------------ | ---- | ----- |
| Solution1 | Recursive post-order swap      | O(n) | O(h)  |
| Solution2 | Iterative BFS level-order swap | O(n) | O(n)  |
