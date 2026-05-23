# Kruskal's Algorithm

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given a weighted undirected graph, find its minimum spanning tree using Kruskal's algorithm. Return the MST as an adjacency list with the same format as the input, containing only the edges selected for the tree.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Sort edges + Union-Find (via Map.entry) | O(E log E) | O(V+E) |
| Solution2 | Sort edges + Union-Find (flattened edge list) | O(E log E) | O(V+E) |
