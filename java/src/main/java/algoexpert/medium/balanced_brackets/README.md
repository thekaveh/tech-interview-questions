# Balanced Brackets

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given a string that may contain brackets (`(`, `)`, `[`, `]`, `{`, `}`), determine whether the brackets are balanced. Every opening bracket must be closed by its matching closing bracket type in the correct order; unmatched or mismatched brackets, or extra closing brackets, make the string unbalanced.

## 2. Solutions

| File      | Approach                         | Time | Space |
| --------- | -------------------------------- | ---- | ----- |
| Solution1 | Stack with List membership check | O(n) | O(n)  |
| Solution2 | Stack with String index lookup   | O(n) | O(n)  |
