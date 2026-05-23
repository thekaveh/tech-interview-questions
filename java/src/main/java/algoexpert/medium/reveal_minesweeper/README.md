# Reveal Minesweeper

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given a minesweeper board represented as a string matrix (where "H" is hidden, "M" is a mine, and "0"–"8" are revealed cells), and the coordinates of the cell a player clicks, simulate the reveal. Clicking a mine marks it "X"; clicking a hidden cell counts adjacent mines and either reveals the count or flood-fills all neighboring hidden cells if no adjacent mines exist.

## 2. Solutions

| File      | Approach                                   | Time   | Space  |
| --------- | ------------------------------------------ | ------ | ------ |
| Solution1 | Recursive DFS flood-fill from clicked cell | O(r·c) | O(r·c) |
