# Quick Select

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given an array of distinct integers and a position k (1-indexed), find the k-th smallest element without fully sorting the array. The solution should be efficient on average by using a partitioning strategy.

## 2. Solutions

| File      | Approach                                            | Time                  | Space        |
| --------- | --------------------------------------------------- | --------------------- | ------------ |
| Solution1 | 3-way partition quickselect (iterative)             | O(n) avg, O(n²) worst | O(1)         |
| Solution2 | 3-way partition quickselect (recursive)             | O(n) avg, O(n²) worst | O(log n) avg |
| Solution3 | 3-way partition quickselect (iterative, while-true) | O(n) avg, O(n²) worst | O(1)         |
