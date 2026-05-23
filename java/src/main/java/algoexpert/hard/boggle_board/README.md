# Boggle Board

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given a 2D board of characters and a list of words, find all words from the list that can be formed by tracing a path through adjacent (including diagonal) cells on the board. Each cell may be used at most once per word. Return the list of found words.

## 2. Solutions

| File      | Approach                | Time             | Space        |
| --------- | ----------------------- | ---------------- | ------------ |
| Solution1 | Trie + backtracking DFS | O(w·m + r·c·8^m) | O(w·m + r·c) |
