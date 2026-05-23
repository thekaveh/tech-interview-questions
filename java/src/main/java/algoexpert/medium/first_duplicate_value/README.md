# First Duplicate Value

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given an array of integers where all values are between 1 and the length of the array (inclusive), return the first value that appears twice when scanning left to right. If no duplicate exists, return -1.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | HashSet membership tracking | O(n) | O(n) |
| Solution2 | In-place sign marking as visited flag | O(n) | O(1) |
