# Longest Subarray With Ones After Replacement

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** Educative

## 1. Problem

Given a binary array and an integer k, find the length of the longest contiguous subarray of 1s you can achieve by flipping at most k zeros to ones.

## 2. Solutions

| File      | Approach                                                                                  | Time | Space |
| --------- | ----------------------------------------------------------------------------------------- | ---- | ----- |
| Solution1 | Variable-size sliding window tracking max ones seen; shrink when zeros in window exceed k | O(n) | O(1)  |
