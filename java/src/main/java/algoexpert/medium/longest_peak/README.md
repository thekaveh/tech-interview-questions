# Longest Peak

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given an array of integers, find and return the length of the longest "peak" — a contiguous sequence of at least three elements that strictly increases to a tip and then strictly decreases. Return 0 if no peak exists.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Brute force: enumerate all (lo, tip, hi) triples | O(n³) | O(1) |
| Solution2 | Scan for peaks, then expand each peak outward | O(n) | O(1) |
| Solution3 | Scan for peaks, count length incrementally outward | O(n) | O(1) |
