# Longest Word

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** CodeSignal

## 1. Problem

Given a string containing words separated by non-alphabetic characters, return the longest word; if there is a tie, return the first one.

## 2. Solutions

| File      | Approach                                           | Time | Space |
| --------- | -------------------------------------------------- | ---- | ----- |
| Solution1 | Two-pointer word extraction, track longest         | O(n) | O(n)  |
| Solution2 | Split on non-word characters, stream max by length | O(n) | O(n)  |
