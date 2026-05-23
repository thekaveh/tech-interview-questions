# Lowest Common Manager

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given an organizational hierarchy (a tree of OrgChart nodes), and two employee nodes, find the lowest-level manager who directly or indirectly manages both employees. The top manager is always an ancestor of both.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Post-order DFS counting descendants found | O(n) | O(d) |
| Solution2 | BFS parent map + depth-based LCA | O(n) | O(n) |
