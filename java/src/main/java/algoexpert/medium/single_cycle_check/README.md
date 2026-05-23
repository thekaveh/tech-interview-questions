# Single Cycle Check

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given an array of non-zero integers where each value represents a jump offset (positive = forward, negative = backward, wrapping around), determine whether all indices are visited exactly once in a single cycle that returns to the starting index 0.

## 2. Solutions

| File      | Approach                                        | Time | Space |
| --------- | ----------------------------------------------- | ---- | ----- |
| Solution1 | Iterative jump simulation with early-exit check | O(n) | O(1)  |
| Solution2 | Recursive jump simulation with jump counter     | O(n) | O(n)  |
