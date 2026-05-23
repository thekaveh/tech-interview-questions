# Laptop Rentals

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given a list of rental time intervals [start, end], determine the minimum number of laptops needed so that no two overlapping rentals share the same machine. Each laptop can only be used by one renter at a time.

## 2. Solutions

| File      | Approach                                   | Time       | Space |
| --------- | ------------------------------------------ | ---------- | ----- |
| Solution1 | Sort by start + min-heap of end times      | O(n log n) | O(n)  |
| Solution2 | Sort by start + min-heap of full intervals | O(n log n) | O(n)  |
| Solution3 | Pre-load min-heap then sweep by start time | O(n log n) | O(n)  |
