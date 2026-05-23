# Concatenate Arrays

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

Given two integer arrays A and B, return a single new array containing all elements of A followed by all elements of B, preserving the original order within each.

## 2. Solutions

| File      | Approach                                                     | Time   | Space  |
| --------- | ------------------------------------------------------------ | ------ | ------ |
| Solution1 | Manual index-tracked loop copying A then B into result array | O(n+m) | O(n+m) |
| Solution2 | System.arraycopy for each segment in bulk                    | O(n+m) | O(n+m) |
