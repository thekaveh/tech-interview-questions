# Underscorify Substring

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given a string and a pattern substring, wrap every occurrence of the pattern in the string with underscores. Overlapping or adjacent occurrences should be merged so that at most two underscores appear between any two consecutive occurrences.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Find all match intervals, merge overlaps, insert underscores | O(n·m + k) | O(n+k) |
