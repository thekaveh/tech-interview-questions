# Box Blur

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** CodeSignal

## 1. Problem

Apply a box blur to an image matrix: replace each interior cell with the floor of the average of its 3x3 neighborhood, returning the resulting smaller matrix.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Nested loops with explicit 3x3 neighbor enumeration | O(R*C) | O(R*C) |
