# Longest Substring With Same Letters After Replacement

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** Educative

## 1. Problem

Given a string and an integer k, find the length of the longest substring containing the same letter after replacing at most k characters. The goal is to maximize the run of a single repeated character.

## 2. Solutions

| File      | Approach                                                                              | Time | Space |
| --------- | ------------------------------------------------------------------------------------- | ---- | ----- |
| Solution1 | Sliding window + character count; shrink when (window size − max frequency) exceeds k | O(n) | O(1)  |
