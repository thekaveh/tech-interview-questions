# Sum BSTs

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given a binary tree, find the sum of all nodes that belong to a BST subtree of size ≥ 3. A subtree qualifies only if it is itself a valid BST (with all strict BST ordering), and its root's contribution counts toward the sum of its subtree's qualifying parent.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Post-order DFS tracking BST validity, range, size, and subtree sums | O(n) | O(h) |
