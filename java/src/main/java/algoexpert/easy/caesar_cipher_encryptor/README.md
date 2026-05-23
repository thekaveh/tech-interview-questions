# Caesar Cipher Encryptor

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** AlgoExpert

## 1. Problem

Shift every lowercase letter in a string forward by a given integer key, wrapping around the alphabet, and return the resulting ciphertext string. The input contains only lowercase English letters, and the shift key may be larger than 26. Each character is shifted independently using modular arithmetic.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution0 | Arithmetic modulo 26 | O(n) | O(n) |
| Solution1 | Alphabet string indexOf lookup | O(n) | O(n) |
| Solution2 | Arithmetic modulo 26, char cast | O(n) | O(n) |
