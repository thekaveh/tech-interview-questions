# All Kinds Of Node Depths

![Difficulty](https://img.shields.io/badge/difficulty-very--hard-red)
**Source:** AlgoExpert

## 1. Problem

Given a binary tree, compute the sum over all nodes of the sum of depths of all nodes in each node's subtree. In other words, for every node v, add the depths of all nodes relative to v, then sum those values across all nodes v.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Iterative DFS per node computing subtree depth sums | O(n log n) | O(h) |
| Solution2 | Recursive: for each node, add its subtree depth sum | O(n log n) | O(h) |
| Solution3 | Single-pass DFS accumulating running depth sum | O(n) | O(h) |
