import java.util.*;

class Solution2 {
    public static int longestPeak(int[] A) {
        var R = 0;
        var N = A.length;

        for(var tip = 1; tip < N - 1; tip++) {
            var isPeak = A[tip - 1] < A[tip] && A[tip] > A[tip + 1];

            if(!isPeak) { continue; }

            int lo = tip, hi = tip;

            for(; 0 < lo && A[lo - 1] < A[lo]; lo--);
            for(; hi < N - 1 && A[hi] > A[hi + 1]; hi++);

            var L = hi - lo + 1;

            if(L < 3) { continue; }

            R = Math.max(R, L);
        }

        return R;
    }
}