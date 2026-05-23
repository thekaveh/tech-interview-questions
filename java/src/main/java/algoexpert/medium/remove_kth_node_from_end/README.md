# Remove Kth Node From End

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given the head of a singly linked list and a positive integer `k`, remove the k-th node from the end of the list in place. The list is modified directly without allocating a new list, and the head node is never actually removed (its value is overwritten if it is the target).

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Two-pointer: advance tail k steps, then march both | O(n) | O(1) |
