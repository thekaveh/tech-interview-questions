# Swap Adjacent Bits

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

Given a 32-bit integer, swap every pair of adjacent bits — bit 0 with bit 1, bit 2 with bit 3, and so on. Return the resulting integer.

## 2. Solutions

| File      | Approach                                                                             | Time | Space |
| --------- | ------------------------------------------------------------------------------------ | ---- | ----- |
| Solution1 | Shift odd-position bits left and even-position bits right using alternating bitmasks | O(1) | O(1)  |
| Solution2 | Mask odd and even bit groups separately, then shift and OR to combine                | O(1) | O(1)  |
