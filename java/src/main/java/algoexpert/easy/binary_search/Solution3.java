package algoexpert.easy.binary_search;
import java.util.*;

// Approach: TODO.
class Solution3 {
    public static int binarySearch(int[] A, int v) {
        var N = A.length;

        return binarySearch(A, v, 0, N - 1);
    }

    private static int binarySearch(int[] A, int v, int lo, int hi) {
        if(hi < lo) { return -1; }

        var mid = lo + (hi - lo) / 2;
        var cmp = Integer.valueOf(v).compareTo(A[mid]);

        if      (cmp < 0)   { return binarySearch(A, v, lo, mid - 1); }
        else if (0 < cmp)   { return binarySearch(A, v, mid + 1, hi); }
        else                { return mid; }
    }
}
