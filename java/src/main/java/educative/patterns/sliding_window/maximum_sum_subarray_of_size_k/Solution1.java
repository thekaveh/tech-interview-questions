package educative.patterns.sliding_window.maximum_sum_subarray_of_size_k;
import java.util.*;

// Approach: Fixed-size sliding window maintaining a running sum, sliding by subtracting the element leaving the window.
class Solution1 {
    public static int findMaxSumSubArray(int k, int[] A) {
        int N = A.length;

        int lo = 0;
        int R = 0;
        int S = 0;

        for (int hi = 0; hi < N; hi++) {
            S += A[hi];

            if (hi - lo + 1 >= k) {
                R = Math.max(R, S);

                S -= A[lo++];
            }
        }

        return R;
    }
}
