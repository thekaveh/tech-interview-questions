# Smallest Difference

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given two arrays of integers, find the pair of values (one from each array) whose absolute difference is smallest. Return the pair as a two-element array; if multiple pairs are tied, return any one of them.

## 2. Solutions

| File      | Approach                                             | Time                 | Space  |
| --------- | ---------------------------------------------------- | -------------------- | ------ |
| Solution1 | MinPQ over all pairs, extract minimum                | O(m·n log(m·n))      | O(m·n) |
| Solution2 | MaxPQ keeping only the best pair seen                | O(m·n log 1)         | O(1)   |
| Solution3 | Sort both, two-pointer with tracked best indices     | O(m log m + n log n) | O(1)   |
| Solution4 | Sort both, two-pointer with tracked best pair values | O(m log m + n log n) | O(1)   |
