# Max Multiple

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

Given a divisor and an upper bound, find the largest integer that is both a multiple of the divisor and does not exceed the bound.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Linear scan from bound downward to find first multiple | O(divisor) | O(1) |
| Solution2 | Direct formula: floor(bound / divisor) * divisor | O(1) | O(1) |
