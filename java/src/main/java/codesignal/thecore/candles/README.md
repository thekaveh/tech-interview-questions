# Candles

![Difficulty](https://img.shields.io/badge/difficulty-easy-yellowgreen)
**Source:** CodeSignal

## 1. Problem

You start with a supply of candles that can be burned down completely. Once you accumulate makeNew spent stubs, you can recycle them into one new candle. Given the initial count and the recycling threshold, return the total number of candles you will ever burn.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Simulation loop tracking stubs and accumulating total burned | O(log n) | O(1) |
| Solution2 | Closed-form: initial + floor((initial − 1) / (makeNew − 1)) | O(1) | O(1) |
