package codesignal.thecore.arithmetic_expression;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution2 {
    static boolean solution(int A, int B, int C) {
        return A + B == C || A - B == C || A * B== C || A == B * C;
    }
}
