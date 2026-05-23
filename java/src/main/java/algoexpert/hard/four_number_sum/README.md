# Four Number Sum

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given an array of integers and a target sum, find all unique quadruplets (four distinct elements by index) whose values add up to the target. Return every such quadruplet as a list.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Four nested loops brute force | O(n⁴) | O(1) |
| Solution2 | Sort + two outer loops + two pointers | O(n³) | O(1) |
| Solution3 | Hash map of pair sums | O(n²) avg | O(n²) |
