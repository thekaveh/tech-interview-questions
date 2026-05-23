# Shape Area

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** CodeSignal

## 1. Problem

A cross-shaped figure is built by layering squares: layer 1 is a single cell, each additional layer adds 4 cells to each side; given n layers, find the total area.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| solution-1.java | Recursive summation of 4*(n-1) per layer | O(n) | O(n) |
| solution-2.java | Closed-form formula: n² + (n-1)² | O(1) | O(1) |
