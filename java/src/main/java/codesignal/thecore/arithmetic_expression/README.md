# Arithmetic Expression

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

Given three integers a, b, and c, determine whether placing one of the four arithmetic operators (+, -, *, /) between a and b can produce c. Division counts only when the quotient is exact (no remainder).

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Explicit check of all four operations with exact-division guard | O(1) | O(1) |
| Solution2 | Compact boolean chain covering add, subtract, multiply, and reversed division | O(1) | O(1) |
