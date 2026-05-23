package algoexpert.hard.index_equals_value;
import java.util.*;

// Approach: Binary search (iterative, leftmost bias).
class Solution1 {
    public int indexEqualsValue(int[] A) {
        var N = A.length;

        var lo = 0;
        var hi = N - 1;

        while (lo <= hi) {
            var mid = lo + (hi - lo) / 2;
            var cmp = Integer.valueOf(A[mid]).compareTo(mid);

            if      (cmp < 0)   { lo = mid + 1; }
            else if (0 < cmp)   { hi = mid - 1; }
            else {
                if (0 < mid && A[mid - 1] == A[mid] - 1)    { hi = mid - 1; }
                else                                        { return mid; }
            }
        }

        return -1;
    }
}
