# Min Height BST

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given a sorted array of unique integers, construct a BST with the minimum possible height. The median of each subarray becomes the root, with the left half forming the left subtree and the right half forming the right subtree recursively.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Divide and conquer with lo/hi index bounds | O(n) | O(n) |
| Solution2 | Divide and conquer using subList slicing | O(n) | O(n) |
