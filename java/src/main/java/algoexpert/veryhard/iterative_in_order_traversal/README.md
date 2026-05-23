# Iterative In Order Traversal

![Difficulty](https://img.shields.io/badge/difficulty-very--hard-red)
**Source:** AlgoExpert

## 1. Problem

Given a binary tree where each node has a parent pointer, perform an in-order traversal iteratively without using a stack or recursion. Apply a callback function to each visited node, using only O(1) extra space.

## 2. Solutions

| File      | Approach                                             | Time | Space |
| --------- | ---------------------------------------------------- | ---- | ----- |
| Solution1 | Parent-pointer walk tracking previous node direction | O(n) | O(1)  |
