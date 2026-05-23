# Prim's Algorithm

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given a weighted undirected graph, find its minimum spanning tree using Prim's algorithm. Return the MST as an adjacency list matching the format of the input, containing only the selected MST edges.

## 2. Solutions

| File      | Approach                                    | Time       | Space  |
| --------- | ------------------------------------------- | ---------- | ------ |
| Solution1 | Eager Prim with min-heap of crossing edges  | O(E log E) | O(V+E) |
| Solution2 | Lazy Prim tracking cheapest edge per vertex | O(E log V) | O(V)   |
