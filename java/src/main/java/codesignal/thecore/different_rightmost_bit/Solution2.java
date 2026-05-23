package codesignal.thecore.different_rightmost_bit;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: XOR in-place, then isolate lowest set bit with x & -x.
class Solution2 {
    static int solution(int n, int m) {
        return (n ^= m) & -n;
    }
}
