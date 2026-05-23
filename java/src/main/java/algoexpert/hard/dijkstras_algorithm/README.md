# Dijkstra's Algorithm

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given a weighted directed graph with V vertices (represented as an adjacency list) and a source vertex s, compute the shortest distance from s to every other vertex. Return -1 for vertices unreachable from the source.

## 2. Solutions

| File      | Approach                                    | Time           | Space |
| --------- | ------------------------------------------- | -------------- | ----- |
| Solution1 | Min-heap Dijkstra (lazy, duplicate entries) | O((V+E) log V) | O(V)  |
| Solution2 | Min-heap Dijkstra with explicit remove      | O((V+E) log V) | O(V)  |
| Solution3 | Min-heap Dijkstra with in-queue tracking    | O((V+E) log V) | O(V)  |
| Solution4 | Min-heap Dijkstra with VertexInfo wrapper   | O((V+E) log V) | O(V)  |
