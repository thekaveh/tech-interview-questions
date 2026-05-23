# Min Rewards

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Assign a positive integer reward to each student based on their scores. Every student must receive at least 1 reward, and any student with a higher score than an adjacent neighbor must receive more rewards than that neighbor. Find the minimum total rewards needed.

## 2. Solutions

| File      | Approach                                                | Time | Space |
| --------- | ------------------------------------------------------- | ---- | ----- |
| Solution1 | Two-pass linear scan (left-to-right then right-to-left) | O(n) | O(n)  |
