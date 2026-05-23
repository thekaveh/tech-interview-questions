package codesignal.intro.array_max_consecutive_sum;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Sliding window.
class Solution1 {
    static int solution(int[] A, int k) {
        var N = A.length;

        var T = 0;
        var S = Integer.MIN_VALUE;

        var lo = 0;
        for(var hi = 0; hi < N; hi++) {
            T += A[hi];

            if(hi - lo + 1 == k) {
                S = Math.max(S, T);

                T -= A[lo++];
            }
        }

        return S;
    }
}
