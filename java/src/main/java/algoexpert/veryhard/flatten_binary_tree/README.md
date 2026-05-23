# Flatten Binary Tree

![Difficulty](https://img.shields.io/badge/difficulty-very--hard-red)
**Source:** AlgoExpert

## 1. Problem

Given a binary tree, flatten it into a doubly linked list using the tree's left and right pointers (left = previous, right = next) in in-order sequence. Return the head (leftmost / in-order first) node of the resulting linked list.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Collect in-order nodes then wire left/right pointers | O(n) | O(n) |
| Solution2 | Recursive divide-and-conquer returning [head, tail] pairs | O(n) | O(h) |
