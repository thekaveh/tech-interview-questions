# Max Path Sum In Binary Tree

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given a binary tree where nodes may hold negative values, find the maximum sum of any path in the tree. A path is any sequence of connected nodes; it does not need to pass through the root, and each node may appear at most once.

## 2. Solutions

| File      | Approach                                                 | Time | Space |
| --------- | -------------------------------------------------------- | ---- | ----- |
| Solution1 | Post-order DFS tracking branch-includable and global max | O(n) | O(h)  |
