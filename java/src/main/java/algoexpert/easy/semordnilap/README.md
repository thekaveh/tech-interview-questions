# Semordnilap

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** AlgoExpert

## 1. Problem

An array of unique lowercase strings is provided; find all pairs of distinct words where one word is the reverse of the other (a semordnilap pair) and return those pairs in any order. Each word in the input appears at most once, so a word and its reverse cannot both appear independently as the same string. Return an empty list if no such pairs exist.

## 2. Solutions

| File      | Approach                                 | Time     | Space    |
| --------- | ---------------------------------------- | -------- | -------- |
| Solution1 | HashMap groups words with their reverses | O(n · m) | O(n · m) |
| Solution2 | HashSet, remove on match                 | O(n · m) | O(n · m) |
