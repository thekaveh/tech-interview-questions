# Missing Numbers

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given an array of `n` integers where every value in [1, n+2] appears exactly once except for exactly two missing values, find and return those two missing values in ascending order.

## 2. Solutions

| File      | Approach                                  | Time | Space |
| --------- | ----------------------------------------- | ---- | ----- |
| Solution1 | HashSet membership scan                   | O(n) | O(n)  |
| Solution2 | Sum-based partition into two halves       | O(n) | O(1)  |
| Solution3 | XOR to isolate two missing values via LSB | O(n) | O(1)  |
