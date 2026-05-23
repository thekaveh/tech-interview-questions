# Sunset Views

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given an array of building heights and a direction ("EAST" or "WEST"), return the indices of buildings that have a sunset view — buildings that are strictly taller than all buildings between them and the horizon in the specified direction. Return the indices in ascending order.

## 2. Solutions

| File      | Approach                                         | Time | Space |
| --------- | ------------------------------------------------ | ---- | ----- |
| Solution1 | Single pass from horizon side, track running max | O(n) | O(n)  |
