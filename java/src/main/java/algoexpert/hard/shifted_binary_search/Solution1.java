package algoexpert.hard.shifted_binary_search;
import java.util.*;

// Approach: Modified binary search distinguishing sorted half.
class Solution1 {
    public static int shiftedBinarySearch(int[] A, int v) {
        var N = A.length;

        var lo = 0;
        var hi = N - 1;

        while (lo <= hi) {
            var mid = lo + (hi - lo) / 2;

            if (A[mid] == v) { return mid; }

            if (A[lo] <= A[mid]) {
                if (A[lo] <= v && v < A[mid])   { hi = mid - 1; }
                else                            { lo = mid + 1; }
            }
            else {
                if (A[mid] < v && v <= A[hi])   { lo = mid + 1; }
                else                            { hi = mid - 1; }
            }
        }

        return -1;
    }
}
