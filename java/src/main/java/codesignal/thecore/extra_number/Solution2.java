package codesignal.thecore.extra_number;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: XOR of all three values; the pair cancels leaving the unique number.
class Solution2 {
    static int solution(int a, int b, int c) {
        return a ^ b ^ c;
    }
}
