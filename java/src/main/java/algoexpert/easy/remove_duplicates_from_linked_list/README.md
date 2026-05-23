# Remove Duplicates From Linked List

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** AlgoExpert

## 1. Problem

A singly linked list whose nodes are sorted in ascending order is provided; remove every duplicate node so that each value appears exactly once, and return the modified list head. Nodes are removed by relinking pointers — no auxiliary data structure is needed because the sorted order groups equal values contiguously.

## 2. Solutions

| File      | Approach                            | Time | Space |
| --------- | ----------------------------------- | ---- | ----- |
| Solution1 | Nested loop, skip duplicate chain   | O(n) | O(1)  |
| Solution2 | Two-pointer advance past duplicates | O(n) | O(1)  |
| Solution3 | Single pointer, inner while skip    | O(n) | O(1)  |
