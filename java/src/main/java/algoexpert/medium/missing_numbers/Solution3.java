package algoexpert.medium.missing_numbers;
import java.util.*;

// Approach: XOR to isolate two missing values via LSB.
class Solution3 {
    // Time: O(n) | Space: O(1)
    public int[] missingNumbers(int[] A) {
        var N = A.length + 2;

        var xor = 0;
        for(var a = 1; a <= N; a++) { xor ^= a; }
        for(var a : A)              { xor ^= a; }

        var lsb = 1;
        while((xor & lsb) == 0) { lsb <<= 1; }

        var n1 = 0;
        var n2 = 0;
        for(var a = 1; a <= N; a++) {
            if((a & lsb) == 0) { n1 ^= a; }
            else               { n2 ^= a; }
        }

        for(var a : A) {
            if((a & lsb) == 0) { n1 ^= a; }
            else               { n2 ^= a; }
        }

        return (n1 < n2)
            ? new int[] { n1, n2 }
            : new int[] { n2, n1 };
    }
}
