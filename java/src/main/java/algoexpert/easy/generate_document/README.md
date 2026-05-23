# Generate Document

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** AlgoExpert

## 1. Problem

A bag of characters and a target document string are provided; determine whether the document can be generated using only the characters available in the bag (each character consumed once per use). Return true if possible, false otherwise. Spaces and special characters may appear in both inputs and must also be accounted for.

## 2. Solutions

| File      | Approach                            | Time     | Space |
| --------- | ----------------------------------- | -------- | ----- |
| Solution1 | Frequency map, decrement on match   | O(n + m) | O(c)  |
| Solution2 | Frequency map, remove on exhaustion | O(n + m) | O(c)  |
