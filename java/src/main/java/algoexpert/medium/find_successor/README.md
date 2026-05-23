# Find Successor

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given a binary tree where each node has a parent pointer, and a reference to a specific node, find and return its in-order successor — the next node in a left–node–right traversal. Return null if the given node is the last in-order node.

## 2. Solutions

| File      | Approach                                      | Time | Space |
| --------- | --------------------------------------------- | ---- | ----- |
| Solution1 | Full in-order into queue, scan for node       | O(n) | O(n)  |
| Solution2 | Reverse in-order into stack, pop to find node | O(n) | O(n)  |
| Solution3 | Reverse in-order with early stop at target    | O(n) | O(n)  |
| Solution4 | Direct pointer traversal using parent links   | O(h) | O(1)  |
