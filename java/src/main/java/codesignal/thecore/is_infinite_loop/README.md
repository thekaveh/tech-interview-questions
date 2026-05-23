# Is Infinite Loop

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

A loop starts at value a and increments by 2 on each step. Determine whether the loop will ever reach value b exactly — it cannot if a > b or if the step size of 2 means the parity of a and b differs.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Check: loop is infinite if a > b or (b − a) is odd | O(1) | O(1) |
