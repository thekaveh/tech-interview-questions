# Addition Without Carrying

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

Add two positive integers digit-by-digit, discarding any carry that would occur at each column. Each decimal position is summed modulo 10, and no carry propagates to the next position. Return the resulting integer.

## 2. Solutions

| File      | Approach                                                     | Time     | Space    |
| --------- | ------------------------------------------------------------ | -------- | -------- |
| Solution1 | Iterative digit-by-digit assembly building result string     | O(log n) | O(log n) |
| Solution2 | Recursive digit processing using modulo and integer division | O(log n) | O(log n) |
