# Find Nodes Distance K

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given a binary tree, a target node value, and an integer k, return all node values that are exactly k edges away from the target node. Movement can go through parent or child edges.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Parent-map DFS + BFS level-order | O(n) | O(n) |
