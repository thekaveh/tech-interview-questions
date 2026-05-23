# Min Heap Construction

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Implement a min-heap data structure backed by a list, supporting `buildHeap` (heapify an existing list in O(n)), `peek` (minimum), `insert`, and `remove` (extract minimum). The heap property requires that each parent is less than or equal to its children.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | siftDown / siftUp with explicit child/parent index helpers | O(n) build, O(log n) insert/remove | O(n) |
| Solution2 | siftDown / siftUp using out-of-order child/parent index finders | O(n) build, O(log n) insert/remove | O(n) |
