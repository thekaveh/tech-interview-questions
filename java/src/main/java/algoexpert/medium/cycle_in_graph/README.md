# Cycle In Graph

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given a directed graph represented as an adjacency list (array of int arrays), determine whether the graph contains at least one cycle. A cycle exists when a DFS traversal finds a back edge — an edge pointing to a vertex already on the current recursion stack.

## 2. Solutions

| File      | Approach                                          | Time     | Space |
| --------- | ------------------------------------------------- | -------- | ----- |
| Solution1 | DFS wrapped in a class, HashMap-based state       | O(v + e) | O(v)  |
| Solution2 | DFS with Graph/DFS classes, boolean arrays        | O(v + e) | O(v)  |
| Solution3 | DFS with Graph class using adjacency HashMap      | O(v + e) | O(v)  |
| Solution4 | DFS with Graph class and keyset iteration         | O(v + e) | O(v)  |
| Solution5 | DFS with boolean visited + recursion-stack arrays | O(v + e) | O(v)  |
