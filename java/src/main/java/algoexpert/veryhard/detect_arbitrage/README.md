# Detect Arbitrage

![Difficulty](https://img.shields.io/badge/difficulty-very--hard-red)
**Source:** AlgoExpert

## 1. Problem

Given a matrix of currency exchange rates where entry [i][j] is the rate to convert currency i to currency j, determine whether an arbitrage opportunity exists — a sequence of conversions that returns more than the starting amount.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Bellman-Ford on -log(rate) graph to detect negative cycles | O(V³) | O(V) |
