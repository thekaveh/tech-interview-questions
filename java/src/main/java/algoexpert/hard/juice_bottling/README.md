# Juice Bottling

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given an array `prices` where `prices[i]` is the revenue for a bottle of exactly `i` units of juice, find the sizes of bottles you should fill to maximize total revenue when starting with `prices.length - 1` units. Return the chosen bottle sizes (order does not matter).

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Bottom-up DP with split backtracking | O(n²) | O(n) |
