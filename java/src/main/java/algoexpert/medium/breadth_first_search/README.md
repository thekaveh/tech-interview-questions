# Breadth First Search

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given a node in a directed acyclic graph where each node has a name and a list of children, traverse the graph in breadth-first order and return a list of node names in the order they are visited. The traversal starts from the node on which the method is called.

## 2. Solutions

| File      | Approach                  | Time     | Space |
| --------- | ------------------------- | -------- | ----- |
| Solution1 | BFS with ArrayDeque       | O(v + e) | O(v)  |
| Solution2 | BFS with LinkedList Queue | O(v + e) | O(v)  |
