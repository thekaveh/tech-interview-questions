# Minimum Characters For Words

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given an array of words, return the smallest array of characters that, when arranged, can spell any single word in the array. For each character, the result must include as many copies as the maximum frequency of that character across all words.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Per-word freq map merged into global max-freq map | O(n · w) | O(c) |
| Solution2 | Same logic with cleaner per-word map merging | O(n · w) | O(c) |
