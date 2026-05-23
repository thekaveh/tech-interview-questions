# Interweaving Strings

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given three strings A, B, and C, determine whether C can be formed by interleaving characters from A and B while preserving the relative order of characters within each source string. The lengths must satisfy |A| + |B| == |C|.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Bottom-up 2-D DP | O(|A|·|B|) | O(|A|·|B|) |
| Solution2 | Top-down recursion with memoization | O(|A|·|B|) | O(|A|·|B|) |
