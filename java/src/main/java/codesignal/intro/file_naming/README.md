# File Naming

![Difficulty](https://img.shields.io/badge/difficulty-warm--up-green)
**Source:** CodeSignal

## 1. Problem

Given a list of file names to be created in order, resolve conflicts by appending "(k)" to duplicates, where k is the smallest positive integer that makes the name unique.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| solution-1.java | LinkedHashMap tracking next suffix per name, retry loop | O(n * conflicts) | O(n) |
