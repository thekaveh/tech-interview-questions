package algoexpert.medium.missing_numbers;
import java.util.*;

// Approach: Sum-based partition into two halves.
class Solution2 {
    // Time: O(n) | Space: O(1)
    public int[] missingNumbers(int[] A) {
        var N = A.length + 2;
    
        var sum = 0;
        for(var a = 1; a <= N; a++) { sum += a; }
        for(var a : A)              { sum -= a; }
    
        var n1 = 0;
        var n2 = 0;
        var avg = sum / 2;
        for(var a = 1; a <= N; a++) {
            if(a <= avg) { n1 += a; }
            else         { n2 += a; }
        }
    
        for(var a : A) {
            if(a <= avg) { n1 -= a; }
            else         { n2 -= a; }
        }
    
        return new int[] { n1, n2 };
    }
}
