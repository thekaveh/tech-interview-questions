# Water Area

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given an array of non-negative integers representing the heights of walls at each position, compute how much rainwater would be trapped between the walls after a rainstorm. Water at each position is bounded by the shorter of the tallest walls to its left and right.

## 2. Solutions

| File      | Approach                                                        | Time | Space |
| --------- | --------------------------------------------------------------- | ---- | ----- |
| Solution1 | Precompute left-max and right-max arrays, then accumulate water | O(n) | O(n)  |
