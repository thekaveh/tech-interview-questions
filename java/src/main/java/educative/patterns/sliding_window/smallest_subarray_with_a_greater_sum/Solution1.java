package educative.patterns.sliding_window.smallest_subarray_with_a_greater_sum;
import java.util.*;

// Approach: Variable-size sliding window growing right until sum meets target, then shrinking left to minimize length.
class Solution1 {
    public static int findMinSubArray(int S, int[] A) {
        int N = A.length, lo = 0, hi = 0, s = 0, L = Integer.MAX_VALUE;

        for (hi = 0; hi < N; hi++) {
            s += A[hi];

            while (S <= s) {
                int l = hi - lo + 1;
                L = Math.min(L, l);

                s -= A[lo++];
            }
        }

        return L == Integer.MAX_VALUE ? 0 : L;
    }
}
