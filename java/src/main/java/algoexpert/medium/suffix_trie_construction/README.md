# Suffix Trie Construction

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Implement a suffix trie that, given a string, inserts every suffix into a trie structure and supports a `contains` query that checks whether a given substring appears in the original string. Each inserted suffix is terminated with a special end-of-word character `*`.

## 2. Solutions

| File      | Approach                                             | Time                    | Space |
| --------- | ---------------------------------------------------- | ----------------------- | ----- |
| Solution1 | Recursive insertion and lookup                       | O(n²) build, O(m) query | O(n²) |
| Solution2 | Iterative insertion and lookup                       | O(n²) build, O(m) query | O(n²) |
| Solution3 | Recursive insertion and lookup (alternate base case) | O(n²) build, O(m) query | O(n²) |
