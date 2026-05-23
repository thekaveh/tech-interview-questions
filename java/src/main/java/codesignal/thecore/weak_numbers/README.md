# Weak Numbers

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

A number's "weakness" is the count of preceding numbers that have strictly more divisors than it does. Among all integers 1 through n, find the maximum weakness value and count how many numbers achieve that maximum. Return both as a two-element array.

## 2. Solutions

| File      | Approach                                                                                       | Time       | Space |
| --------- | ---------------------------------------------------------------------------------------------- | ---------- | ----- |
| Solution1 | Compute divisor count for each number 1–n, then compute weakness by scanning all prior numbers | O(n² · √n) | O(1)  |
