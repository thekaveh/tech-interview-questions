# Two Colorable

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given a directed graph as an adjacency list, determine whether it is two-colorable (bipartite) — i.e., whether its vertices can be colored with two colors such that no two adjacent vertices share the same color. A graph with an odd-length cycle is not two-colorable.

## 2. Solutions

| File      | Approach                                | Time     | Space |
| --------- | --------------------------------------- | -------- | ----- |
| Solution1 | Recursive DFS graph coloring            | O(v + e) | O(v)  |
| Solution2 | Iterative DFS graph coloring with stack | O(v + e) | O(v)  |
