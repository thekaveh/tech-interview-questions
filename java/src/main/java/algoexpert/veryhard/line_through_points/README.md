# Line Through Points

![Difficulty](https://img.shields.io/badge/difficulty-very--hard-red)
**Source:** AlgoExpert

## 1. Problem

Given a list of 2D points, find the maximum number of points that lie on a single straight line. Any two points define a line, and a point is always on its own lines.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | For each anchor point, hash normalized slopes to other points | O(n²) | O(n) |
