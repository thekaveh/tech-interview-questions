# Longest Palindromic Substring

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given a string, return the longest substring that reads the same forwards and backwards (a palindrome). If multiple substrings share the maximum length, return any one of them; a single character is always a valid palindrome.

## 2. Solutions

| File      | Approach                                       | Time  | Space |
| --------- | ---------------------------------------------- | ----- | ----- |
| Solution1 | Brute force check all substrings               | O(n³) | O(n)  |
| Solution2 | Expand around each center (odd and even)       | O(n²) | O(n)  |
| Solution3 | Top-down DP memoization on (lo, hi) substrings | O(n²) | O(n²) |
