# Find Permutation In A String

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** Educative

## 1. Problem

Given a string txt and a pattern string, determine whether any permutation of the pattern appears as a contiguous substring of txt. A permutation matches when a window of the pattern's length contains exactly the same character frequencies.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Fixed-size sliding window with character frequency map and matched-count tracking | O(n + m) | O(m) |
