# Merge Binary Trees

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given two binary trees, merge them into a new tree by summing the values of overlapping nodes. Where only one tree has a node, the corresponding node from that tree is used as-is. Return the root of the merged tree.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Recursive merge creating new nodes, treating null as 0 | O(n) | O(n) |
| Solution2 | Recursive merge reusing existing nodes when one is null | O(n) | O(n) |
