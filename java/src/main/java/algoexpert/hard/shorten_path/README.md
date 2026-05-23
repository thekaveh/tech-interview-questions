# Shorten Path

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given an absolute or relative Unix-style file path, simplify it by resolving `.` (current directory) and `..` (parent directory) tokens. Return the shortest equivalent path, preserving whether it is absolute or relative.

## 2. Solutions

| File      | Approach                     | Time | Space |
| --------- | ---------------------------- | ---- | ----- |
| Solution1 | Stack-based token processing | O(n) | O(n)  |
