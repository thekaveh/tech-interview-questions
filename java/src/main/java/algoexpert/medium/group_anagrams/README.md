# Group Anagrams

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given a list of strings, group all anagrams together and return the groups as a list of lists. Two words are anagrams if they contain the same characters with the same frequencies. The order of groups and the order of words within each group do not matter.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Sort each word as map key | O(w · n log n) | O(w · n) |
