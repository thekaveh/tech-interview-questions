# Magical Well

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

You draw water from a magical well n times. On the i-th draw (0-indexed), you collect (a+i)\*(b+i) units of water, where a and b are the initial water levels. Return the total water collected across all n draws.

## 2. Solutions

| File      | Approach                                                             | Time | Space |
| --------- | -------------------------------------------------------------------- | ---- | ----- |
| Solution1 | Iterative sum incrementing a and b each round                        | O(n) | O(1)  |
| Solution2 | IntStream.range mapping each draw index to its product, then summing | O(n) | O(1)  |
