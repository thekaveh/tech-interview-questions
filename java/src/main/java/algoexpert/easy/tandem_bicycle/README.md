# Tandem Bicycle

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** AlgoExpert

## 1. Problem

Two equal-length arrays of cyclist speeds (red shirts and blue shirts) and a boolean flag are provided; pair each red-shirt rider with exactly one blue-shirt rider such that the total speed (sum of each pair's faster rider) is either maximised or minimised depending on the flag. Return that total speed. Pairing the fastest of one group with the slowest of the other maximises total speed; matching sorted orders minimises it.

## 2. Solutions

| File      | Approach                                       | Time       | Space |
| --------- | ---------------------------------------------- | ---------- | ----- |
| Solution1 | Sort both, pair with mirrored index if fastest | O(n log n) | O(1)  |
| Solution2 | Sort both, ternary index selection             | O(n log n) | O(1)  |
| Solution3 | Sort, reverse one array if fastest, then pair  | O(n log n) | O(1)  |
| Solution4 | Sort, compute mirrored index via variable      | O(n log n) | O(1)  |
