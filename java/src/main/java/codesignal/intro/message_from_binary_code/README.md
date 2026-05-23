# Message From Binary Code

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** CodeSignal

## 1. Problem

Given a binary string representing ASCII characters (8 bits each), decode it into the corresponding text.

## 2. Solutions

| File      | Approach                                                   | Time | Space |
| --------- | ---------------------------------------------------------- | ---- | ----- |
| Solution1 | Slice 8-bit chunks, parse each as binary int, cast to char | O(n) | O(n)  |
| Solution2 | BigInteger binary parse, convert to byte array             | O(n) | O(n)  |
