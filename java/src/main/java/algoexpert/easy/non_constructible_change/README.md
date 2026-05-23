# Non Constructible Change

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** AlgoExpert

## 1. Problem

An array of positive coin denominations is provided; find the smallest amount of change that cannot be made from any subset of those coins. The coins may be used at most once each, and their values are positive integers. If no coins are given the answer is 1.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Bitmask enumeration of subsets | O(2^n) | O(2^n) |
| Solution2 | Sort, greedy reachability scan | O(n log n) | O(1) |
