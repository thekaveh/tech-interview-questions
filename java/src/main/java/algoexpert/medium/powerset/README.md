# Powerset

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given a list of unique integers, return its power set — the collection of all possible subsets, including the empty set and the full set. A list of n elements has exactly 2^n subsets.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Bitmask enumeration: each integer selects a subset | O(2^n · n) | O(2^n · n) |
| Solution2 | Iterative BFS: for each element expand existing subsets | O(2^n · n) | O(2^n · n) |
| Solution3 | Iterative doubling: append new element to all existing subsets | O(2^n · n) | O(2^n · n) |
| Solution4 | Bitmask with explicit boolean bitmask helper | O(2^n · n) | O(2^n · n) |
