# Colliding Asteroids

![Difficulty](https://img.shields.io/badge/difficulty-medium-yellow)
**Source:** AlgoExpert

## 1. Problem

Given an array of integers where positive values represent asteroids moving right and negative values represent asteroids moving left, simulate collisions. When a right-moving asteroid meets a left-moving one, the smaller (by absolute value) is destroyed; equal-sized asteroids destroy each other. Return the final state of surviving asteroids.

## 2. Solutions

| File | Approach | Time | Space |
|---|---|---|---|
| Solution1 | Stack-based collision simulation | O(n) | O(n) |
