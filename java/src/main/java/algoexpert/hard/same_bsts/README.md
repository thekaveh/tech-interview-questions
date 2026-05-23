# Same BSTs

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given two arrays of integers, determine whether inserting the elements of each array sequentially into an initially empty BST (left for strictly-less, right for greater-or-equal) would produce identical trees — without actually constructing the trees.

## 2. Solutions

| File      | Approach                                                  | Time  | Space |
| --------- | --------------------------------------------------------- | ----- | ----- |
| Solution1 | Recursive structural comparison with valid-range scanning | O(n²) | O(d)  |
