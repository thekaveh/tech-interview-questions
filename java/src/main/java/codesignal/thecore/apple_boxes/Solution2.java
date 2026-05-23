package codesignal.thecore.apple_boxes;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Closed-form formula using sign(-1)^k and triangular number identity.
class Solution2 {
    static int solution(int k) {
        return (int) Math.pow(-1, k) * k * (k + 1) / 2;
    }   
}
