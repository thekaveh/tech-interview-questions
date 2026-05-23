# Split Binary Tree

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given a binary tree, determine whether it can be split into two subtrees of equal sum by removing exactly one edge. If such a split is possible, return the target sum (half the total); otherwise return 0. The total sum must be even for a valid split to exist.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | DFS computing subtree sums, flag when half-sum is found | O(n) | O(h) |
