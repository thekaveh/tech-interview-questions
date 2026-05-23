# Range Bit Count

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

Given two non-negative integers a and b (a ≤ b), count the total number of set bits (1-bits) across all integers in the inclusive range [a, b].

## 2. Solutions

| File      | Approach                                                                    | Time             | Space |
| --------- | --------------------------------------------------------------------------- | ---------------- | ----- |
| Solution1 | Iterate over each number in [a,b] and count its set bits via bit-shift loop | O((b−a) · log b) | O(1)  |
