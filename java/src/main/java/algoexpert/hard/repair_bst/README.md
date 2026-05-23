# Repair BST

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

A BST has had exactly two of its nodes swapped by mistake, breaking the BST property. Find those two nodes and swap their values back so the tree is a valid BST again. Do not change the tree structure.

## 2. Solutions

| File      | Approach                                                         | Time | Space |
| --------- | ---------------------------------------------------------------- | ---- | ----- |
| Solution1 | In-order traversal to detect two out-of-order nodes + value swap | O(n) | O(h)  |
