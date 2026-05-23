# Add Border

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** CodeSignal

## 1. Problem

Given a rectangular grid of strings, surround the entire picture with a border of asterisks and return the resulting array.

## 2. Solutions

| File      | Approach                                        | Time    | Space   |
| --------- | ----------------------------------------------- | ------- | ------- |
| Solution1 | Direct construction with StringBuilder border   | O(n\*m) | O(n\*m) |
| Solution2 | Wrap rows then derive top/bottom via replaceAll | O(n\*m) | O(n\*m) |
