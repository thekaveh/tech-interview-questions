package codesignal.thecore.equal_pair_of_bits;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Bitwise: lowest set bit of NOT(n XOR m) using complement and AND.
class Solution1 {
    static int solution(int n, int m) {
        return (n ^ m) + 1 & ~(n ^ m);
    }
}
