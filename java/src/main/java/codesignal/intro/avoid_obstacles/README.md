# Avoid Obstacles

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** CodeSignal

## 1. Problem

Given obstacle positions on an integer number line, find the smallest integer jump size (≥ 2) such that every landing position avoids all obstacles.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| solution-1.java | Enumerate candidates, check divisibility | O(n * max) | O(n) |
| solution-2.java | Stream filter over candidate jump sizes | O(n * max) | O(1) |
