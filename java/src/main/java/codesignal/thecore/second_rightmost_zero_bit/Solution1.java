package codesignal.thecore.second_rightmost_zero_bit;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static int solution(int n) {
        var rev = new StringBuilder(Integer.toBinaryString(n)).reverse();

        return (int) Math.pow(2, rev.indexOf("0", rev.indexOf("0") + 1));
    }
}
