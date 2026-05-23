# Nth Fibonacci

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** AlgoExpert

## 1. Problem

An integer n is provided; return the nth number in the Fibonacci sequence, where F(1) = 0, F(2) = 1, and each subsequent term is the sum of the two preceding ones. n is at least 1. The sequence is 1-indexed, so F(1) = 0 and F(3) = 1.

## 2. Solutions

| File      | Approach                               | Time   | Space |
| --------- | -------------------------------------- | ------ | ----- |
| Solution1 | Naive recursion                        | O(2^n) | O(n)  |
| Solution2 | Recursive memoization, HashMap         | O(n)   | O(n)  |
| Solution3 | Recursive memoization, array           | O(n)   | O(n)  |
| Solution4 | Iterative, two-variable rolling window | O(n)   | O(1)  |
