# Multi String Search

![Difficulty](https://img.shields.io/badge/difficulty-hard-orange)
**Source:** AlgoExpert

## 1. Problem

Given a large text string and an array of search keys, determine for each key whether it appears as a substring of the text. Return a list of booleans in the same order as the keys.

## 2. Solutions

| File      | Approach                                       | Time | Space |
| --------- | ---------------------------------------------- | ---- | ----- | ----- | --- | --- | --- | ---- | --- |
| Solution1 | Suffix trie of text + membership check per key | O(   | text  | ² + Σ | key | )   | O(  | text | ²)  |
