# Product Sum

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** AlgoExpert

## 1. Problem

A special array is provided that may contain integers and nested arrays to arbitrary depth; compute the "product sum" by summing every element and multiplying nested arrays' sums by their depth level (outer array at depth 1, first-level nested array at depth 2, etc.). Return the resulting integer. The nesting may be several levels deep.

## 2. Solutions

| File      | Approach                             | Time | Space |
| --------- | ------------------------------------ | ---- | ----- |
| Solution1 | Recursive DFS with depth coefficient | O(n) | O(d)  |
