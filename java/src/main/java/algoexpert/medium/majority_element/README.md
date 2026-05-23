# Majority Element

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given an array of integers, find and return the majority element — the value that appears more than half the time. The problem guarantees that such an element always exists in the input.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Bit-level vote: check each of 32 bits | O(32n) | O(1) |
| Solution2 | Boyer-Moore voting algorithm | O(n) | O(1) |
