# Run Length Encoding

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** AlgoExpert

## 1. Problem

A non-empty string is provided; encode it using run-length encoding, where each consecutive run of the same character is represented as its count followed by the character. Runs longer than 9 must be split into chunks of at most 9. Return the encoded string.

## 2. Solutions

| File      | Approach                                     | Time | Space |
| --------- | -------------------------------------------- | ---- | ----- |
| Solution1 | Single pass, inner while extends run         | O(n) | O(n)  |
| Solution2 | Two-index single pass, inner for extends run | O(n) | O(n)  |
| Solution3 | do-while loop, inner while extends run       | O(n) | O(n)  |
| Solution4 | Single pass, count then emit on boundary     | O(n) | O(n)  |
