package algoexpert.hard.index_equals_value;
import java.util.*;

// Approach: Binary search (recursive, leftmost bias).
class Solution2 {
    public int indexEqualsValue(int[] A) {
        var N = A.length;

        return solve(A, 0, N - 1);
    }

    private static int solve(int[] A, int lo, int hi) {
        if (hi < lo) { return -1; }

        var mid = lo + (hi - lo) / 2;
        var cmp = Integer.valueOf(A[mid]).compareTo(mid);

        if      (cmp < 0)   { return solve(A, mid + 1, hi); }
        else if (0 < cmp)   { return solve(A, lo, mid - 1); }
        else                {
            var lt = solve(A, lo, mid - 1);

            return (lt != -1) ? lt : mid;
        }
    }
}
