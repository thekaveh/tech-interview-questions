package algoexpert.medium.zero_sum_subarray;
import java.util.*;

// Approach: TODO.
class Solution1 {
    public boolean zeroSumSubarray(int[] A) {
        var N = A.length;

        for (var lo = 0; lo < N; lo++) {
            var S = 0;

            for (var hi = lo; hi < N; hi++) {
                S += A[hi];

                if (S == 0) { return true; }
            }
        }

        return false;
    }
}
