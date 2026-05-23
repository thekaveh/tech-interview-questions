# Largest Island

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given a binary matrix where 0 represents water and 1 represents land, find the size of the largest island you can form by flipping exactly one water cell to land. An island is a group of 4-directionally connected land cells.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | DFS island labeling + water-cell neighbor union | O(r·c) | O(r·c) |
