# Minimum Passes Of Matrix

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given an integer matrix containing positive, negative, and zero values, return the minimum number of passes needed to convert all negatives to positives by multiplying adjacent (up/down/left/right) negative cells by a neighboring positive. Return -1 if it is impossible to eliminate all negatives.

## 2. Solutions

| File      | Approach                                         | Time      | Space  |
| --------- | ------------------------------------------------ | --------- | ------ |
| Solution1 | Naive: repeatedly scan for convertible negatives | O((r·c)²) | O(r·c) |
| Solution2 | Multi-source BFS seeded from all positive cells  | O(r·c)    | O(r·c) |
| Solution3 | Multi-source BFS, alternate list/queue form      | O(r·c)    | O(r·c) |
