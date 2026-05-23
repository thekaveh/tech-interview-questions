package codesignal.thecore.arithmetic_expression;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Compact boolean chain covering add, subtract, multiply, and reversed division.
class Solution2 {
    static boolean solution(int A, int B, int C) {
        return A + B == C || A - B == C || A * B== C || A == B * C;
    }
}
