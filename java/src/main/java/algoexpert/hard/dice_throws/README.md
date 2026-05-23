# Dice Throws

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given D dice each with S sides (numbered 1 through S), count the number of ways to roll the dice so that their values sum exactly to a target T. Each die contributes a value between 1 and S inclusive.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Bottom-up 2-D DP (dice × target) | O(D·S·T) | O(D·T) |
| Solution2 | Bottom-up DP with bounded inner loop | O(D·S·T) | O(D·T) |
