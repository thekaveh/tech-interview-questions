# Kill Kth Bit

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

Given an integer n and a 1-indexed bit position k, clear (set to 0) the k-th bit of n and return the result. All other bits remain unchanged.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Bitwise AND with the complement of a shifted mask: n & ~(1 << (k−1)) | O(1) | O(1) |
