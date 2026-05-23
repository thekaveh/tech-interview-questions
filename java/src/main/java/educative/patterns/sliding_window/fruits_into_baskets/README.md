# Fruits Into Baskets

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** Educative

## 1. Problem

Given an array of characters representing fruit trees in a row, find the length of the longest contiguous subarray containing at most 2 distinct fruit types. You can only carry 2 baskets and each basket holds one type of fruit.

## 2. Solutions

| File      | Approach                                                                                         | Time | Space |
| --------- | ------------------------------------------------------------------------------------------------ | ---- | ----- |
| Solution1 | Variable-size sliding window with a HashSet shrinking left when distinct count exceeds 2         | O(n) | O(1)  |
| Solution2 | Variable-size sliding window with a frequency map shrinking left and removing zero-count entries | O(n) | O(1)  |
