package algoexpert.hard.search_for_range;
import java.util.*;

// Approach: Two binary searches (iterative) biased left and right.
class Solution1 {
    private static final boolean LEFT = false, RIGHT = true;

    public static int[] searchForRange(int[] A, int key) {
        return new int[] { search(A, key, LEFT), search(A, key, RIGHT) };
    }

    private static int search(int[] A, int key, boolean direction) {
        var N = A.length;

        var lo = 0;
        var hi = N - 1;

        while (lo <= hi) {
            var mid = lo + (hi - lo) / 2;
            var cmp = Integer.valueOf(key).compareTo(A[mid]);

            if      (cmp < 0) { hi = mid - 1; }
            else if (0 < cmp) { lo = mid + 1; }
            else {
                if (direction == LEFT) {
                    if (mid == 0 || A[mid - 1] != A[mid])       { return mid; }
                    else                                        { hi = mid - 1; }
                }
                else {
                    if (mid == N - 1 || A[mid] != A[mid + 1])   { return mid; }
                    else                                        { lo = mid + 1;  }
                }
            }
        }

        return -1;
    }
}
