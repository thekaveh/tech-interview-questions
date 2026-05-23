# Min Max Stack Construction

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Implement a stack that supports `push`, `pop`, `peek`, `getMin`, and `getMax`, all in O(1) time. The min and max must reflect the current contents of the stack after every push or pop operation.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Parallel int arrays for values, mins, maxs | O(1) all ops | O(n) |
| Solution2 | Parallel ArrayList for values, mins, maxs | O(1) all ops | O(n) |
| Solution3 | Intrusive linked list where each node carries its min/max | O(1) all ops | O(n) |
