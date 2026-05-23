# Validate Subsequence

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** AlgoExpert

## 1. Problem

A main sequence array and a candidate subsequence array are provided; determine whether every element of the subsequence appears in the main sequence in the same relative order (not necessarily contiguously) and return a boolean. Elements are matched by value and the subsequence pointer advances only on a match. The subsequence may be longer than the main sequence, in which case the answer is false.

## 2. Solutions

| File      | Approach                              | Time | Space |
| --------- | ------------------------------------- | ---- | ----- |
| Solution1 | Single pass, subsequence pointer j    | O(n) | O(1)  |
| Solution2 | Single pass, dual index for-loop      | O(n) | O(1)  |
| Solution3 | Single pass while-loop, index i and j | O(n) | O(1)  |
