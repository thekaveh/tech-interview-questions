# Count Sum Of Two Representations 2

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

Given integers n, l, and r, count the number of ways to write n as a sum of two integers a + b where l ≤ a ≤ b ≤ r. Each unordered pair is counted once.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Two-pointer converging from l and r, counting pairs that sum to n | O(r−l) | O(1) |
