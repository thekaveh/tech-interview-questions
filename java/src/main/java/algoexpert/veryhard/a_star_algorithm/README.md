# A* Algorithm

![Difficulty](https://img.shields.io/badge/difficulty-very--hard-red)
**Source:** AlgoExpert

## 1. Problem

Given a 2D grid where 0 is passable and 1 is a wall, and source/destination coordinates, find the shortest path from source to destination using the A* search algorithm. Return the sequence of cells on the path, or an empty array if no path exists.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | A* with Manhattan heuristic using Node objects and HashMap | O(r·c·log(r·c)) | O(r·c) |
| Solution2 | A* with Manhattan heuristic using int[] coordinates | O(r·c·log(r·c)) | O(r·c) |
