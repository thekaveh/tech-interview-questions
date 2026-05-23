# Smallest Subarray With A Greater Sum

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** Educative

## 1. Problem

Given an array of positive integers and a target sum S, find the length of the smallest contiguous subarray whose sum is greater than or equal to S. Return 0 if no such subarray exists.

## 2. Solutions

| File      | Approach                                                                                                  | Time | Space |
| --------- | --------------------------------------------------------------------------------------------------------- | ---- | ----- |
| Solution1 | Variable-size sliding window growing right until sum meets target, then shrinking left to minimize length | O(n) | O(1)  |
