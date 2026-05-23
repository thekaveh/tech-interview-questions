# Count Black Cells

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

A straight line is drawn on an n×m grid from the bottom-left to the top-right corner. Count how many unit grid cells the line passes through. Cells that the line merely touches at a corner do not count.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Formula: n + m + gcd(n,m) − 2, derived from inclusion-exclusion on row/column crossings | O(log(min(n,m))) | O(1) |
