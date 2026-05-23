# Find Kth Largest Value In BST

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given a BST and a positive integer `k`, return the k-th largest value in the tree. A reverse in-order traversal (right–node–left) visits nodes in descending order, so the k-th node visited is the answer.

## 2. Solutions

| File      | Approach                                       | Time | Space |
| --------- | ---------------------------------------------- | ---- | ----- |
| Solution1 | Reverse in-order into queue, then skip k-1     | O(n) | O(n)  |
| Solution2 | Reverse in-order with early stop at k elements | O(n) | O(k)  |
