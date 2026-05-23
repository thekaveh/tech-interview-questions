# Make Array Consecutive 2

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** CodeSignal

## 1. Problem

Given an array of distinct integers, find how many numbers need to be added to make the values form a consecutive sequence.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| solution-1.java | Sort, sum gaps between adjacent elements | O(n log n) | O(1) |
| solution-2.java | Sort, compute (max - min + 1) - n | O(n log n) | O(1) |
