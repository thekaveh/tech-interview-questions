# Reconstruct BST

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given a pre-order traversal sequence of a BST (Node–Left–Right), reconstruct and return the original BST. The first element is the root; all subsequent elements smaller than the root belong to the left subtree, and the rest belong to the right subtree.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Recursive with lo/hi index bounds | O(n²) worst | O(n) |
| Solution2 | Recursive using subList slicing | O(n²) worst | O(n) |
