# Square Digits Sequence

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

Starting from a0, repeatedly replace the current number with the sum of the squares of its digits until a repeated number appears. Return the length of the resulting sequence including both the first occurrence and the repeated element.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Simulate with a HashSet tracking visited values; stop on first repeat | O(n) | O(n) |
