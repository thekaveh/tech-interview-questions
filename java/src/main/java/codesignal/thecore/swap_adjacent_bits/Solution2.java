package codesignal.thecore.swap_adjacent_bits;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Mask odd and even bit groups separately, then shift and OR to combine.
class Solution2 {
    static int solution(int n) {
        return (n & 0b01010101010101010101010101010101) << 1 | (n & 0b10101010101010101010101010101010) >> 1;
    } 
}
