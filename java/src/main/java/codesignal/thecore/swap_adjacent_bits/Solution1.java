package codesignal.thecore.swap_adjacent_bits;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static int solution(int n) {
        return (n << 1 & 0b10101010101010101010101010101010) + (n >> 1 & 0b01010101010101010101010101010101);
    } 
}
