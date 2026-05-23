# Disk Stacking

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given a list of disks each described by width, depth, and height, find the tallest stack you can build such that each disk placed on top has all three dimensions strictly less than the disk below it. Return the sequence of disks in the optimal stack.

## 2. Solutions

| File      | Approach                                               | Time  | Space |
| --------- | ------------------------------------------------------ | ----- | ----- |
| Solution1 | Sort by height + LIS-style DP with path reconstruction | O(n²) | O(n)  |
