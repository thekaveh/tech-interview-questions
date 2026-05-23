# Equal Pair Of Bits

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

Given two integers n and m, find the position value of the rightmost bit where they are equal (both 0 or both 1). Return the power of two corresponding to that bit position.

## 2. Solutions

| File      | Approach                                                         | Time | Space |
| --------- | ---------------------------------------------------------------- | ---- | ----- |
| Solution1 | Bitwise: lowest set bit of NOT(n XOR m) using complement and AND | O(1) | O(1)  |
| Solution2 | Integer.lowestOneBit applied to bitwise NOT of (n XOR m)         | O(1) | O(1)  |
