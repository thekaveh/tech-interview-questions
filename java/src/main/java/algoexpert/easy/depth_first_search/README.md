# Depth First Search

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** AlgoExpert

## 1. Problem

A named graph node is provided where each node holds a string name and a list of child nodes; traverse the graph depth-first and return a list of node names in the order they were visited. The graph is a directed acyclic tree rooted at the node on which the method is called. Children of each node should be visited left to right.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Recursive DFS, pre-order | O(v + e) | O(v) |
| Solution2 | Recursive DFS via stack accumulation | O(v + e) | O(v) |
| Solution3 | Iterative DFS with explicit stack | O(v + e) | O(v) |
