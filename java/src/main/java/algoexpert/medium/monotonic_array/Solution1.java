package algoexpert.medium.monotonic_array;
import java.util.*;

// Approach: Single pass tracking both trend flags.
class Solution1 {
    public static boolean isMonotonic(int[] A) {
        var N = A.length;
    
        if(N == 0 || N == 1) { return true; }

        var isMonoInc = true;
        var isMonoDec = true;

        for(var i = 0; i < N - 1; i++) {
            if(A[i] < A[i + 1]) { isMonoDec = false; }
            if(A[i] > A[i + 1]) { isMonoInc = false; }
        }

        return isMonoInc || isMonoDec;
    }
}
