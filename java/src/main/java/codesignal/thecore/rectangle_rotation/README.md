# Rectangle Rotation

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

A rectangle of width a and height b is centered at the origin and rotated 45 degrees. Count how many integer lattice points (grid points with integer coordinates) lie strictly inside or on the boundary of the rotated rectangle.

## 2. Solutions

| File      | Approach                                                                                          | Time   | Space |
| --------- | ------------------------------------------------------------------------------------------------- | ------ | ----- |
| Solution1 | Enumerate integer points in bounding box and test each against the rotated rectangle inequalities | O(a·b) | O(1)  |
