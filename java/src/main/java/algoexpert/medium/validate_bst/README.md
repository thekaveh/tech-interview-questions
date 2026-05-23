# Validate BST

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given a binary tree, determine whether it satisfies the BST property: every node in the left subtree has a value strictly less than the current node, and every node in the right subtree has a value greater than or equal to the current node. This constraint must hold at every level.

## 2. Solutions

| File      | Approach                                                | Time | Space |
| --------- | ------------------------------------------------------- | ---- | ----- |
| Solution1 | Recursive with [min, max) range, combined condition     | O(n) | O(h)  |
| Solution2 | Recursive with [min, max) range, early-exit condition   | O(n) | O(h)  |
| Solution3 | Recursive with [min, max) range, sequential early exits | O(n) | O(h)  |
