# Sum Up Numbers

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** CodeSignal

## 1. Problem

Given a string containing both letters and numbers, extract all embedded integers and return their sum.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| solution-1.java | Two-pointer scan to isolate digit runs, accumulate | O(n) | O(n) |
| solution-2.java | Split on non-digits, filter, parse, reduce | O(n) | O(n) |
