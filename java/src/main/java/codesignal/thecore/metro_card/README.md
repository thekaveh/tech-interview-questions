# Metro Card

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

A metro pass covers one month. Given the number of days in the last month the pass was used, determine which month lengths are possible for the next pass — return the sorted list of valid day counts for the upcoming month.

## 2. Solutions

| File      | Approach                                                                 | Time | Space |
| --------- | ------------------------------------------------------------------------ | ---- | ----- |
| Solution1 | Hardcoded rule: 31-day months are followed by {28,30,31}; others by {31} | O(1) | O(1)  |
