# Calendar Matching

![Difficulty](https://img.shields.io/badge/difficulty-very--hard-red)
**Source:** AlgoExpert

## 1. Problem

Given two people's calendars (lists of busy intervals) and their daily availability bounds, find all time slots where both people are free for at least a given meeting duration. Return the free slots as a list of time intervals in HH:MM format.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Merge all blocked intervals, then scan gaps for fit | O(n log n) | O(n) |
