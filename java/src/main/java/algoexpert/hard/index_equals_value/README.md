# Index Equals Value

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given a sorted array of distinct integers, find the leftmost index i such that A[i] == i. If no such index exists return -1. The array may contain negative numbers, and the solution must run in sub-linear time.

## 2. Solutions

| File      | Approach                                 | Time     | Space    |
| --------- | ---------------------------------------- | -------- | -------- |
| Solution1 | Binary search (iterative, leftmost bias) | O(log n) | O(1)     |
| Solution2 | Binary search (recursive, leftmost bias) | O(log n) | O(log n) |
