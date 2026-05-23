# Reverse Words In String

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given a string of words separated by spaces, return a new string with the words in reversed order while preserving the original spacing between words. The reversal is of whole words, not individual characters.

## 2. Solutions

| File      | Approach                                                     | Time | Space |
| --------- | ------------------------------------------------------------ | ---- | ----- |
| Solution1 | Reverse whole string, then reverse each word in-place        | O(n) | O(n)  |
| Solution2 | Same two-pass reverse with slightly different loop structure | O(n) | O(n)  |
