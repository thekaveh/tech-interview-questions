package algoexpert.medium.longest_peak;
import java.util.*;

// Approach: Scan for peaks, then expand each peak outward.
class Solution2 {
    public static int longestPeak(int[] A) {
        var R = 0;
        var N = A.length;

        for(var tip = 1; tip < N - 1; tip++) {
            var isPeak = A[tip - 1] < A[tip] && A[tip] > A[tip + 1];

            if(!isPeak) { continue; }

            var lo = tip; for(; 0 < lo && A[lo - 1] < A[lo]; lo--);
            var hi = tip; for(; hi < N - 1 && A[hi] > A[hi + 1]; hi++);

            var L = hi - lo + 1;

            if(L < 3) { continue; }

            R = Math.max(R, L);
        }

        return R;
    }
}
