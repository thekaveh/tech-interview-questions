# Optimal Freelancing

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** AlgoExpert

## 1. Problem

An array of freelance jobs is provided, each with a payment amount and a deadline (number of days, max 7) by which it must be completed in a single day; select a subset of jobs to maximise total payment given that only one job can be done per day and all work must be scheduled within a 7-day window. Return the maximum achievable payment. Deadlines beyond 7 are treated as day 7.

## 2. Solutions

| File      | Approach                              | Time       | Space |
| --------- | ------------------------------------- | ---------- | ----- |
| Solution1 | Greedy max-heap, schedule latest slot | O(n log n) | O(n)  |
