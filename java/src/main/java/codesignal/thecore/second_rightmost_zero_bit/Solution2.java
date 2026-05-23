package codesignal.thecore.second_rightmost_zero_bit;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Bit manipulation: skip first zero group with (n \.
class Solution2 {
    static int solution(int n) {
        return ~(n | (n + 1)) & ((n | (n + 1)) + 1);
    }
}
