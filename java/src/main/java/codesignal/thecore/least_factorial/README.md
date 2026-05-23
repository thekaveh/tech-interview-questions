# Least Factorial

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

Given a positive integer n, find the smallest factorial (k! for some k ≥ 1) that is greater than or equal to n.

## 2. Solutions

| File      | Approach                                                                  | Time       | Space |
| --------- | ------------------------------------------------------------------------- | ---------- | ----- |
| Solution1 | Compute successive factorials starting from 1! until the result reaches n | O(n^(1/e)) | O(1)  |
