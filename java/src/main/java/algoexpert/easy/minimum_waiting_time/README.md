# Minimum Waiting Time

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** AlgoExpert

## 1. Problem

An array of query durations is provided; determine the minimum total waiting time for all queries if they are executed sequentially in some order. Each query waits for all queries executed before it to finish. Sorting the queries shortest-first minimises total wait because shorter tasks delay fewer subsequent queries.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Sort, accumulate prefix sums | O(n log n) | O(1) |
| Solution2 | Sort, multiply each by remaining count | O(n log n) | O(1) |
