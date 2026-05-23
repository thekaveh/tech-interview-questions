# Phone Call

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

A phone plan charges min1 cents for the first minute, min2_10 cents for minutes 2–10, and min11 cents per minute thereafter. Given a balance s in cents, return the maximum number of whole minutes you can talk.

## 2. Solutions

| File      | Approach                                                                | Time | Space |
| --------- | ----------------------------------------------------------------------- | ---- | ----- |
| Solution1 | Simulation subtracting per-minute costs until balance is exhausted      | O(t) | O(1)  |
| Solution2 | Direct formula: compute breakpoints for reaching minutes 1, 10, and 11+ | O(1) | O(1)  |
