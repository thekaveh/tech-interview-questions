# Find Closest Value In BST

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** AlgoExpert

## 1. Problem

A binary search tree and a target integer are provided; find the value in the tree that is closest in absolute difference to the target and return it. Each node has a unique value, and the BST property allows pruning subtrees that cannot contain a closer value. There is guaranteed to be at least one node.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Recursive BST traversal, track closest | O(log n) avg | O(log n) avg |
| Solution2 | Iterative BST traversal, track closest | O(log n) avg | O(1) |
