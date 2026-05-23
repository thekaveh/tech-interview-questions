# BST Construction

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Implement a Binary Search Tree class supporting `insert`, `contains`, and `remove` operations. Values less than a node go left, values greater than or equal go right; the BST invariant must be preserved after every mutation, including removing nodes with two children by replacing with the in-order successor.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Recursive insert / contains / remove | O(log n) avg, O(n) worst | O(log n) avg |
| Solution2 | Iterative insert / contains / remove | O(log n) avg, O(n) worst | O(1) |
