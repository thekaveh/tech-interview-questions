# Shortest Unique Prefixes

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given an array of distinct strings, find for each string the shortest prefix that uniquely identifies it among all strings in the array. Return the prefixes in the same order as the input strings.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Trie with per-node child-count + prefix walk | O(n·m) | O(n·m) |
