# Validate Three Nodes

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given three nodes from a BST, determine whether one of the outer nodes is an ancestor of the middle node, and the middle node is an ancestor of the other outer node — in other words, whether nodeOne -> nodeTwo -> nodeThree or nodeThree -> nodeTwo -> nodeOne forms a valid ancestor chain.

## 2. Solutions

| File      | Approach                                 | Time | Space |
| --------- | ---------------------------------------- | ---- | ----- |
| Solution1 | BST-guided descendant search (iterative) | O(h) | O(1)  |
| Solution2 | BST-guided descendant search (recursive) | O(h) | O(h)  |
