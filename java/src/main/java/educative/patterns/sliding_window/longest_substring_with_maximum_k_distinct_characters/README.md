# Longest Substring With Maximum K Distinct Characters

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** Educative

## 1. Problem

Given a string and an integer k, find the length of the longest substring that contains at most k distinct characters.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Variable-size sliding window with hash map; shrink left while distinct character count exceeds k | O(n) | O(k) |
