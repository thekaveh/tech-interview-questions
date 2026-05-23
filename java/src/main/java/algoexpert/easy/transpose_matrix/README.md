# Transpose Matrix

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** AlgoExpert

## 1. Problem

A 2D integer matrix (which may be non-square) is provided; return its transpose — a new matrix where element at row r, column c moves to row c, column r. The input matrix has at least one row and one column. A new matrix of dimensions columns × rows is allocated and filled; the original is not modified.

## 2. Solutions

| File      | Approach                              | Time     | Space    |
| --------- | ------------------------------------- | -------- | -------- |
| Solution1 | Allocate new matrix, nested loop fill | O(r · c) | O(r · c) |
