# Continuous Median

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Design a data structure that supports inserting integers one at a time and querying the running median after each insertion. The median is the middle value of the sorted sequence, or the average of the two middle values when the count is even.

## 2. Solutions

| File      | Approach                                    | Time                        | Space |
| --------- | ------------------------------------------- | --------------------------- | ----- |
| Solution1 | Two heaps (max-heap lower + min-heap upper) | O(log n) insert, O(1) query | O(n)  |
