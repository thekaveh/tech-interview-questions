package algoexpert.medium.longest_peak;
import java.util.*;

// Approach: Scan for peaks, count length incrementally outward.
class Solution3 {
    public static int longestPeak(int[] A) {
        var R = 0;
        var N = A.length;

        for(var tip = 1; tip < N - 1; tip++) {
            var isPeak = A[tip - 1] < A[tip] && A[tip] > A[tip + 1];

            if(!isPeak) { continue; }

            var L = 1;
            for(var lo = tip; 0 < lo && A[lo - 1] < A[lo]; lo--)        { L++; }
            for(var hi = tip; hi < N - 1 && A[hi] > A[hi + 1]; hi++)    { L++; }

            if(L < 3) { continue; }

            R = Math.max(R, L);
        }

        return R;
    }
}
