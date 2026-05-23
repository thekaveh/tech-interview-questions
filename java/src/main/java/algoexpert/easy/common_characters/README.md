# Common Characters

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** AlgoExpert

## 1. Problem

An array of strings is provided; find all characters that appear in every single string and return them in any order. A character only counts once per string regardless of how many times it appears there. The returned array contains each qualifying character exactly once.

## 2. Solutions

| File      | Approach                            | Time     | Space |
| --------- | ----------------------------------- | -------- | ----- |
| Solution1 | Per-string dedup set, frequency map | O(n · m) | O(c)  |
