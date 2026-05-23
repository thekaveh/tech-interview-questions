# Symmetrical Tree

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given a binary tree, determine whether it is symmetric (a mirror image of itself). A tree is symmetric if the left subtree is a mirror reflection of the right subtree at every level.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Iterative BFS: compare mirrored node pairs each level | O(n) | O(n) |
| Solution2 | Recursive: compare left subtree with mirrored right subtree | O(n) | O(h) |
| Solution3 | Recursive with explicit null checks before value comparison | O(n) | O(h) |
