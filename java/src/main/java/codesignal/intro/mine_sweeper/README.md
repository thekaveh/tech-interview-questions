# Mine Sweeper

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** CodeSignal

## 1. Problem

Given a boolean matrix indicating mine positions, produce an integer matrix where each non-mine cell holds the count of adjacent mines (8-directional).

## 2. Solutions

| File      | Approach                                     | Time    | Space   |
| --------- | -------------------------------------------- | ------- | ------- |
| Solution1 | For each mine, increment all valid neighbors | O(R\*C) | O(R\*C) |
