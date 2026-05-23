# Candies

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

There are n children and m candies. Distribute candies so every child receives the same whole number of them. Return the total number of candies that are actually distributed (the largest multiple of n that does not exceed m).

## 2. Solutions

| File      | Approach                          | Time | Space |
| --------- | --------------------------------- | ---- | ----- |
| Solution1 | Subtract remainder: m − (m mod n) | O(1) | O(1)  |
