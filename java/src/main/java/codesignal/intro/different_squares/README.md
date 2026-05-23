# Different Squares

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** CodeSignal

## 1. Problem

Given a matrix of integers, count the number of distinct 2x2 squares that can be formed from adjacent cells.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| solution-1.java | HashSet of custom Square objects with manual equals/hashCode | O(R*C) | O(R*C) |
| solution-2.java | HashSet of canonical string keys per 2x2 block | O(R*C) | O(R*C) |
