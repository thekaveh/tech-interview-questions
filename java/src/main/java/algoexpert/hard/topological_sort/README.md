# Topological Sort

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given a list of jobs (vertices) and a list of dependency pairs (directed edges meaning "job A must finish before job B"), produce a valid ordering of all jobs. If a cycle makes ordering impossible, return an empty list.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | DFS-based topological sort with cycle detection | O(V+E) | O(V+E) |
| Solution2 | DFS on explicit Graph class with adjacency list | O(V+E) | O(V+E) |
