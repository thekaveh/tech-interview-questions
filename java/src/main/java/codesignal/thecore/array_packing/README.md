# Array Packing

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

Given an array of up to 4 non-negative integers each fitting in one byte (0–255), pack them into a single 32-bit integer by placing the first element in the least significant byte, the second in the next byte, and so on. Return the packed result.

## 2. Solutions

| File      | Approach                                                      | Time | Space |
| --------- | ------------------------------------------------------------- | ---- | ----- |
| Solution1 | Shift each element into its byte lane and OR into accumulator | O(n) | O(1)  |
