# Blackjack Probability

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given a target score and a starting hand value, compute the probability of busting in a simplified Blackjack game where the dealer draws cards valued 1–10 with equal probability (10%) each. The dealer stops drawing if the hand reaches `target - 4` or higher (i.e., any hand within 4 of the target is considered safe; exceeding the target is a bust).

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Top-down recursion with memoization | O(target) | O(target) |
