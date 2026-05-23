# Tournament Winner

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** AlgoExpert

## 1. Problem

A list of head-to-head competition pairs and a corresponding list of result indicators (1 = first team won, 0 = second team won) are provided; determine which team has the highest total score across all matches and return that team's name. Every match has exactly one winner, and there are no draws. The tournament structure guarantees a single overall winner.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Score map (+3 per win), linear scan for max | O(n) | O(k) |
| Solution2 | Score map (+3 per win), track max during scan | O(n) | O(k) |
| Solution3 | Score map (+1 per win), track max during scan | O(n) | O(k) |
