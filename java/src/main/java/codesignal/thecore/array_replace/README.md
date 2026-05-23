# Array Replace

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

Given an integer array and two values fromElem and toElem, replace every occurrence of fromElem in the array with toElem and return the modified array.

## 2. Solutions

| File      | Approach                                                        | Time | Space |
| --------- | --------------------------------------------------------------- | ---- | ----- |
| Solution1 | In-place linear scan with conditional assignment                | O(n) | O(1)  |
| Solution2 | Stream map replacing matching elements, collecting to new array | O(n) | O(n)  |
