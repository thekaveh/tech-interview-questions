# Comfortable Numbers

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

Two distinct numbers a and b are "comfortable" with each other when b lies within [a − digitSum(a), a + digitSum(a)] and a lies within [b − digitSum(b), b + digitSum(b)]. Given a range [l, r], count all comfortable pairs within that range.

## 2. Solutions

| File      | Approach                                                              | Time          | Space |
| --------- | --------------------------------------------------------------------- | ------------- | ----- |
| Solution1 | Brute-force pair enumeration with extracted digit-sum helper          | O(n² · log n) | O(1)  |
| Solution2 | Brute-force pair enumeration using stream-based digit-sum computation | O(n² · log n) | O(1)  |
