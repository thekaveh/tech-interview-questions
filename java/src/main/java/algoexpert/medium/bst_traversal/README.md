# BST Traversal

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given a BST and an accumulator list, implement three traversal methods: in-order (left–node–right, producing sorted output), pre-order (node–left–right), and post-order (left–right–node). Each method appends node values to the provided list and returns it.

## 2. Solutions

| File      | Approach                                       | Time | Space |
| --------- | ---------------------------------------------- | ---- | ----- |
| Solution1 | Recursive traversal with null guard            | O(n) | O(n)  |
| Solution2 | Recursive traversal with explicit child checks | O(n) | O(n)  |
