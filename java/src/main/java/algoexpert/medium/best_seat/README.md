# Best Seat

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given a row of seats represented as an array of 0s (empty) and 1s (occupied), find the index of the empty seat that maximizes distance to the nearest occupied seat. If there are multiple gaps of the same maximum size, the leftmost best seat wins; return -1 if no valid seat exists.

## 2. Solutions

| File      | Approach                       | Time | Space |
| --------- | ------------------------------ | ---- | ----- |
| Solution1 | Linear scan of contiguous gaps | O(n) | O(1)  |
