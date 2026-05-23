# Merging Linked Lists

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given two singly linked lists that may share a common tail, find and return the node at which they merge (by reference identity, not value). If the lists do not intersect, return null.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | HashSet of nodes from list A, scan list B | O(m + n) | O(m) |
| Solution2 | Length-equalize pointers then advance in tandem | O(m + n) | O(1) |
