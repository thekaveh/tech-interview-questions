# Longest Most Frequent Prefix

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given an array of strings, find the longest prefix that is shared by the greatest number of strings. If multiple prefixes are tied for the highest frequency, return the longest among them.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Trie with per-node frequency count | O(n·m) | O(n·m) |
