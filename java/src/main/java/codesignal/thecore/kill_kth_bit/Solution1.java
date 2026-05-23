package codesignal.thecore.kill_kth_bit;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Bitwise AND with the complement of a shifted mask: n & ~(1 << (k−1)).
class Solution1 {
    static int solution(int n, int k) {
        return n & ~(1 << (k - 1));
    }
}
