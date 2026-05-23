package algoexpert.hard.min_number_of_jumps;
import java.util.*;

// Approach: Top-down memoized recursion.
class Solution2 {
    public static int minNumberOfJumps(int[] A) {
        int N = A.length;
        var M = new Integer[N];

        return solve(A, 0, M);
    }

    private static int solve(int[] A, int at, Integer[] M) {
        int N = A.length;

        if (M[at] != null) {
            return M[at];
        }
        if (at == N - 1) {
            return M[at] = 0;
        }

        var ret = Integer.MAX_VALUE;

        for (var i = at + 1; i <= at + A[at] && i < N; i++) {
            ret = Math.min(ret, 1 + solve(A, i, M));
        }

        return M[at] = ret;
    }
}
