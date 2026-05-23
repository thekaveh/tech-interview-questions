# Subarray Sort

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given an array of integers, find the smallest subarray that, when sorted, makes the entire array sorted in ascending order. Return the start and end indices of that subarray, or [-1, -1] if the array is already sorted.

## 2. Solutions

| File      | Approach                                                 | Time | Space |
| --------- | -------------------------------------------------------- | ---- | ----- |
| Solution1 | Find out-of-order min/max, then expand to correct bounds | O(n) | O(1)  |
