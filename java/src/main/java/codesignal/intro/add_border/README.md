# Add Border

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** CodeSignal

## 1. Problem

Given a rectangular grid of strings, surround the entire picture with a border of asterisks and return the resulting array.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| solution-1.java | Direct construction with StringBuilder border | O(n*m) | O(n*m) |
| solution-2.java | Wrap rows then derive top/bottom via replaceAll | O(n*m) | O(n*m) |
