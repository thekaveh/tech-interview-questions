# Seats In Theater

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

In a theater with nCols columns and nRows rows, you are sitting at position (col, row). Count how many seats have a worse (further back and further right) view than yours — those in higher-numbered rows and higher-numbered columns.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Formula: (nCols − col + 1) * (nRows − row) | O(1) | O(1) |
