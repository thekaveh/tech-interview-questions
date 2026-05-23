# Next Greater Element

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given a circular array of integers, return an array where each index holds the next greater element found by scanning to the right (wrapping around). If no greater element exists for a position, store -1.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Brute force double-pass circular scan per element | O(n²) | O(n) |
| Solution2 | Monotone stack with backwards double-pass | O(n) | O(n) |
