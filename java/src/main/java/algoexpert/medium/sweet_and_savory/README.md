# Sweet And Savory

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given an array of dish "flavor scores" (negative = sweet, positive = savory) and a target combined flavor, find the pair of one sweet and one savory dish whose combined score is closest to the target without exceeding it. Return the pair as a two-element array, or [0, 0] if no valid pair exists.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Sort + brute-force all pairs with min-PQ for best | O(n² log n) | O(n²) |
| Solution2 | Sort + two-pointer from both ends toward target | O(n log n) | O(1) |
