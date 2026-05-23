# Height Balanced Binary Tree

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given a binary tree, determine whether it is height-balanced — a tree where for every node, the heights of the left and right subtrees differ by at most 1. An empty tree is considered height-balanced.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Naive recursive: check balance and recompute height separately | O(n log n) | O(h) |
| Solution2 | Single-pass DFS with TreeInfo record (height + balanced flag) | O(n) | O(h) |
| Solution3 | Single-pass DFS returning Map.Entry<height, balanced> | O(n) | O(h) |
