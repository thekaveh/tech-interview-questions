# Second Rightmost Zero Bit

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

Given a positive integer n, find the position value (power of 2) of its second rightmost zero bit in binary representation.

## 2. Solutions

| File      | Approach                                                                          | Time     | Space    |
| --------- | --------------------------------------------------------------------------------- | -------- | -------- |
| Solution1 | Convert to binary string, find second '0' index via two indexOf calls             | O(log n) | O(log n) |
| Solution2 | Bit manipulation: skip first zero group with (n \| (n+1)), then isolate next zero | O(1)     | O(1)     |
