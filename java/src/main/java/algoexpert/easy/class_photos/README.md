# Class Photos

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** AlgoExpert

## 1. Problem

Two groups of students (red shirts and blue shirts) of equal size need to be arranged for a photo in two rows; determine whether a valid arrangement exists where every student in one row is strictly taller than the student directly in front of them. Both lists are the same length, and the same group must occupy the back row for all positions. The answer is either true or false — there is no partial arrangement.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Sort descending, compare pairwise with flag | O(n log n) | O(1) |
| Solution2 | Sort descending, assign front/back row | O(n log n) | O(1) |
