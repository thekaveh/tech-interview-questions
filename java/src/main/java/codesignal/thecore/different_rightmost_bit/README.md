# Different Rightmost Bit

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

Given two integers n and m, find the position value of the rightmost bit where they differ — that is, return the power of two corresponding to the lowest set bit of n XOR m.

## 2. Solutions

| File      | Approach                                               | Time | Space |
| --------- | ------------------------------------------------------ | ---- | ----- |
| Solution1 | XOR then Integer.lowestOneBit to isolate differing bit | O(1) | O(1)  |
| Solution2 | XOR in-place, then isolate lowest set bit with x & -x  | O(1) | O(1)  |
