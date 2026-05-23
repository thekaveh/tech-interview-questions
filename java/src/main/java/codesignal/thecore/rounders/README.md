# Rounders

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

Round an integer to the nearest power of 10 by repeatedly rounding its last digit: if the last significant digit is less than 5 it is dropped; otherwise it causes the next digit to round up. Continue until only one digit remains, then restore the trailing zeros.

## 2. Solutions

| File      | Approach                                                           | Time     | Space    |
| --------- | ------------------------------------------------------------------ | -------- | -------- |
| Solution1 | Recursive digit-by-digit rounding with carry propagation           | O(log n) | O(log n) |
| Solution2 | Iterative peel-and-round loop tracking accumulated trailing factor | O(log n) | O(1)     |
