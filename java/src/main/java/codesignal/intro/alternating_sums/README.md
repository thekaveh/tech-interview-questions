# Alternating Sums

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** CodeSignal

## 1. Problem

Given an array of integers representing weights, split them into two teams by alternating positions (odd-indexed vs even-indexed) and return the total weight of each team.

## 2. Solutions

| File      | Approach                                               | Time | Space |
| --------- | ------------------------------------------------------ | ---- | ----- |
| Solution1 | Single pass with two accumulators                      | O(n) | O(1)  |
| Solution2 | Single pass using index parity into two-element result | O(n) | O(1)  |
