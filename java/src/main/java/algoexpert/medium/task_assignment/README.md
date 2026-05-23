# Task Assignment

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given `k` workers and a list of `2k` tasks with durations, assign exactly two tasks to each worker such that the total time (the maximum of any worker's combined task duration) is minimized. Return the assignment as a list of index pairs.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Sort by duration, pair shortest with longest | O(n log n) | O(n) |
