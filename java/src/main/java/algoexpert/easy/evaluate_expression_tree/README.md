# Evaluate Expression Tree

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** AlgoExpert

## 1. Problem

A binary tree representing an arithmetic expression is provided; leaf nodes contain operand values (non-negative integers) while internal nodes encode operators as negative sentinels (-1 = add, -2 = subtract, -3 = divide, -4 = multiply). Evaluate the expression and return the integer result. The tree is well-formed and always has a valid result.

## 2. Solutions

| File      | Approach                        | Time | Space |
| --------- | ------------------------------- | ---- | ----- |
| Solution1 | Recursive post-order evaluation | O(n) | O(h)  |
