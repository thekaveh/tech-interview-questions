# Two Number Sum

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** AlgoExpert

## 1. Problem

An array of distinct integers and a target sum are provided; find the two numbers that add up to the target and return them as a two-element array, or return an empty array if no such pair exists. Each number may only be used once. Negative integers may appear in the input.

## 2. Solutions

| File      | Approach                            | Time       | Space |
| --------- | ----------------------------------- | ---------- | ----- |
| Solution1 | Brute force nested loop             | O(n²)      | O(1)  |
| Solution2 | Sort + binary search for complement | O(n log n) | O(1)  |
| Solution3 | Sort + two pointers                 | O(n log n) | O(1)  |
