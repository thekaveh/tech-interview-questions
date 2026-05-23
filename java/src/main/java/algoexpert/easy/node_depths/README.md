# Node Depths

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** AlgoExpert

## 1. Problem

A binary tree is provided; compute the sum of the depths of every node, where depth is defined as the distance (in edges) from the root. The root has depth 0, its children depth 1, and so on. Return the total as a single integer.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | BFS level-order, accumulate depth per level | O(n) | O(n) |
| Solution2 | Recursive DFS, pass depth down | O(n) | O(h) |
| Solution3 | Iterative DFS, custom Pair node+depth | O(n) | O(n) |
| Solution4 | Iterative DFS, Map.Entry node+depth | O(n) | O(n) |
