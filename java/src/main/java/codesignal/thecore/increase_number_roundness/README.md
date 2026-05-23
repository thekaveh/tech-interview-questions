# Increase Number Roundness

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

A number's "roundness" is defined by how many trailing zeros it has. Given an integer n, determine whether you can increase its roundness by replacing exactly one non-zero digit with a zero — that is, whether there is any non-trailing zero buried between non-zero digits.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Two-pointer scan trimming trailing zeros then checking for an interior zero | O(log n) | O(log n) |
| Solution2 | Regex match for an interior zero followed by any non-zero suffix | O(log n) | O(log n) |
