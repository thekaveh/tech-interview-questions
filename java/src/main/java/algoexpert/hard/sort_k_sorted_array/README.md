# Sort K Sorted Array

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given an array of integers where every element is at most k positions away from its sorted position, sort the array efficiently. A brute-force full sort works but is not optimal given the constraint.

## 2. Solutions

| File      | Approach                               | Time       | Space |
| --------- | -------------------------------------- | ---------- | ----- |
| Solution1 | Min-heap of size k+1, streaming output | O(n log k) | O(k)  |
| Solution2 | Min-heap filling ahead then draining   | O(n log k) | O(k)  |
