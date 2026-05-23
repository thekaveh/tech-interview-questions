# Build Palindrome

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** CodeSignal

## 1. Problem

Given a string, find the shortest palindrome that can be formed by appending characters to the end (i.e., find the longest palindromic suffix and prepend the necessary prefix).

## 2. Solutions

| File      | Approach                                                           | Time  | Space |
| --------- | ------------------------------------------------------------------ | ----- | ----- |
| Solution1 | Shrink prefix until suffix is palindrome, then prepend             | O(n²) | O(n)  |
| Solution2 | Grow suffix boundary until palindrome, then append reversed prefix | O(n²) | O(n)  |
