# Permutations

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given a list of unique integers, generate and return all permutations of those integers. Every possible ordering of all elements must appear exactly once in the output; the order of the permutations themselves does not matter.

## 2. Solutions

| File      | Approach                                                       | Time      | Space     |
| --------- | -------------------------------------------------------------- | --------- | --------- |
| Solution1 | Iterative insertion into each position of growing permutations | O(n · n!) | O(n · n!) |
| Solution2 | Backtracking: pick-and-remove each element                     | O(n · n!) | O(n · n!) |
| Solution3 | Backtracking: in-place swap at each position                   | O(n · n!) | O(n · n!) |
