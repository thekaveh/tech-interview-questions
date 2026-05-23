package algoexpert.easy.binary_search;
import java.util.*;

// Approach: TODO.
class Solution2 {
    public static int binarySearch(int[] A, int v) {
        var N = A.length;

        var lo = 0;
        var hi = N - 1;

        while(lo <= hi) {
            var mid = lo + (hi - lo) / 2;
            var cmp = Integer.valueOf(v).compareTo(A[mid]);

            if     (cmp < 0) { hi = mid - 1; }
            else if(0 < cmp) { lo = mid + 1; }
            else             { return mid; }
        }

        return -1;
    }
}
