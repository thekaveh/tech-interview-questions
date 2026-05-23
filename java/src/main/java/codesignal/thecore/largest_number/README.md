# Largest Number

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

Given a positive integer n, return the largest n-digit integer — that is, the number formed by n nines (e.g., n=3 gives 999).

## 2. Solutions

| File      | Approach                                                            | Time | Space |
| --------- | ------------------------------------------------------------------- | ---- | ----- |
| Solution1 | Build the result by appending a 9 for each digit position in a loop | O(n) | O(1)  |
| Solution2 | Closed-form: 10^n − 1                                               | O(1) | O(1)  |
