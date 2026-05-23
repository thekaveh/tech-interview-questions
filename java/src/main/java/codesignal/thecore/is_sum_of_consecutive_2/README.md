# Is Sum Of Consecutive 2

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

Given a positive integer n, count how many ways it can be written as the sum of two or more consecutive positive integers. For example, 15 = 4+5+6 = 1+2+3+4+5 = 7+8, so the answer is 3.

## 2. Solutions

| File      | Approach                                                            | Time  | Space |
| --------- | ------------------------------------------------------------------- | ----- | ----- |
| Solution1 | Nested loop trying all starting values and accumulating prefix sums | O(n²) | O(1)  |
