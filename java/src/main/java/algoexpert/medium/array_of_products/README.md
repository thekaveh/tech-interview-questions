# Array Of Products

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given an array of integers, return a new array where each element at index `i` is the product of every other element in the input array (i.e., the product of all elements except `A[i]`). The input may contain zeros, and you cannot use division.

## 2. Solutions

| File      | Approach                                    | Time | Space |
| --------- | ------------------------------------------- | ---- | ----- |
| Solution1 | Left-pass then right-pass products          | O(n) | O(n)  |
| Solution2 | Left-pass then right-pass, fill-initialized | O(n) | O(n)  |
