# Pages Numbering With Ink

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

You are printing page numbers starting from a given page, and you have a limited supply of ink measured in digits. Starting at page `current`, keep printing pages while you have enough ink for each page's digit count. Return the last page number successfully printed.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Simulate printing pages, deducting digit count until ink runs out | O(n · log n) | O(1) |
