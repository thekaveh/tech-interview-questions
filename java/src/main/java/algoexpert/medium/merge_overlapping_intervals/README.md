# Merge Overlapping Intervals

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given an array of intervals, each represented as a pair `[start, end]`, merge all overlapping intervals and return the resulting array of non-overlapping intervals sorted by start time. Two intervals overlap when one's start is less than or equal to the other's end.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | MinPQ sort + pairwise merge with re-offer | O(n log n) | O(n) |
| Solution2 | MinPQ sort + extend last result interval in place | O(n log n) | O(n) |
| Solution3 | MinPQ sort + merge by peeking next before polling | O(n log n) | O(n) |
