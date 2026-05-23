# Linked List Construction

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Implement a doubly linked list class supporting `setHead`, `setTail`, `insertBefore`, `insertAfter`, `insertAtPosition`, `removeNodesWithValue`, `remove`, and `containsNodeWithValue`. Nodes are pre-existing objects and may already belong to the list; they must be re-positioned rather than duplicated when moved.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Direct pointer manipulation with remove-before-insert | O(1) per op (O(n) for insertAtPosition) | O(1) |
