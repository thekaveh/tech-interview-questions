package algoexpert.medium.max_subset_sum_no_adjacent;
import java.util.*;

// Approach: Dynamic programming with full DP array.
class Solution1 {
    public static int maxSubsetSumNoAdjacent(int[] A) {
        var N = A.length;

        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return A[0];
        }

        var M = new int[N];
        M[0] = A[0];
        M[1] = Math.max(A[0], A[1]);

        for (var i = 2; i < N; i++) {
            M[i] = Math.max(M[i - 1], M[i - 2] + A[i]);
        }

        return M[N - 1];
    }
}
