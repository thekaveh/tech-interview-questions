# Valid IP Addresses

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given a string of digits, return all valid IPv4 addresses that can be formed by inserting exactly three dots. Each of the four components must be a non-negative integer from 0 to 255 with no leading zeros (unless it is "0" itself).

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Triple nested loop over split points, validate each part | O(1) bounded | O(1) bounded |
| Solution2 | Same triple loop with alternative validity check (no leading zeros via re-stringify) | O(1) bounded | O(1) bounded |
