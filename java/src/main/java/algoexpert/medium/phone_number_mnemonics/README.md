# Phone Number Mnemonics

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given a string of digits (2–9), return all possible letter combinations it could represent on a phone keypad (e.g., 2 maps to "abc"). Digits 0 and 1 have no letters and are left unchanged. All combinations must be returned; order does not matter.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Iterative BFS expansion with char-array substitution | O(4^n · n) | O(4^n · n) |
| Solution2 | Iterative BFS expansion with StringBuilder substitution | O(4^n · n) | O(4^n · n) |
