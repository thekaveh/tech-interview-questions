# Levenshtein Distance

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given two strings, compute the minimum number of single-character edits (insertions, deletions, or substitutions) required to transform one string into the other. This is the classic edit distance (Levenshtein distance) problem.

## 2. Solutions

| File      | Approach                                                     | Time     | Space    |
| --------- | ------------------------------------------------------------ | -------- | -------- |
| Solution1 | Top-down recursion with 2-D memoization (shrinking suffixes) | O(a · b) | O(a · b) |
| Solution2 | Bottom-up DP table (growing prefixes)                        | O(a · b) | O(a · b) |
