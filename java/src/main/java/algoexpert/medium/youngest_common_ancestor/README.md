# Youngest Common Ancestor

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given an ancestral tree where each node has a parent pointer, a root node, and two target nodes, find and return the youngest (deepest) common ancestor of the two targets. The ancestor is guaranteed to exist since all nodes share the same root.

## 2. Solutions

| File      | Approach                                        | Time | Space |
| --------- | ----------------------------------------------- | ---- | ----- |
| Solution1 | Compute depths, equalize, then walk up together | O(d) | O(1)  |
