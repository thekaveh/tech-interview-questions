package codesignal.thecore.equal_pair_of_bits;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution2 {
    static int solution(int n, int m) {
        return Integer.lowestOneBit(~(n ^ m));
    }
}
