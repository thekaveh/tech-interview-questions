# Longest Substring With Distinct Characters

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** Educative

## 1. Problem

Given a string, find the length of the longest substring in which every character appears exactly once (no duplicates). The window must contain all distinct characters.

## 2. Solutions

| File      | Approach                                                                                                      | Time | Space |
| --------- | ------------------------------------------------------------------------------------------------------------- | ---- | ----- |
| Solution1 | Variable-size sliding window with a map storing each character's last-seen index; jump left pointer on repeat | O(n) | O(k)  |
