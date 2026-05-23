# Right Sibling Tree

![Difficulty](https://img.shields.io/badge/difficulty-very--hard-red)
**Source:** AlgoExpert

## 1. Problem

Given a binary tree, transform it in-place so that each node's right pointer points to its right sibling at the same level (the next node to its right on the same depth). Nodes with no right sibling should have their right pointer set to null. Return the root.

## 2. Solutions

| File      | Approach                                      | Time | Space |
| --------- | --------------------------------------------- | ---- | ----- |
| Solution1 | BFS level-order traversal with null sentinels | O(n) | O(n)  |
