# River Sizes

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given a 2-D matrix of 0s and 1s where 1s represent water (river cells) and 0s represent land, find the sizes of all rivers. A river is a connected group of 1s (connected horizontally or vertically); return the list of river sizes in any order.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | DFS from each unvisited water cell, count component size | O(r·c) | O(r·c) |
