# Longest Word

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** CodeSignal

## 1. Problem

Given a string containing words separated by non-alphabetic characters, return the longest word; if there is a tie, return the first one.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| solution-1.java | Two-pointer word extraction, track longest | O(n) | O(n) |
| solution-2.java | Split on non-word characters, stream max by length | O(n) | O(n) |
