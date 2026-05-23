# Apple Boxes

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

You have k rows of boxes numbered 1 through k. Red boxes occupy even-numbered rows and contain i² apples each; yellow boxes occupy odd-numbered rows and also contain i² apples each. Return the difference between the total number of red apples and total number of yellow apples.

## 2. Solutions

| File      | Approach                                                            | Time | Space |
| --------- | ------------------------------------------------------------------- | ---- | ----- |
| Solution1 | Loop accumulating alternating +/- squared row sums                  | O(k) | O(1)  |
| Solution2 | Closed-form formula using sign(-1)^k and triangular number identity | O(1) | O(1)  |
