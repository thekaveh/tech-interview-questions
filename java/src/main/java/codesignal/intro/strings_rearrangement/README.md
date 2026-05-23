# Strings Rearrangement

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** CodeSignal

## 1. Problem

Given an array of same-length strings, determine whether they can be arranged in a sequence where each consecutive pair of strings differs by exactly one character.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| solution-1.java | Generate all permutations, check each for consecutive one-diff property | O(n! * n) | O(n!) |
