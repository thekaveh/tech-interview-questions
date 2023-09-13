import java.util.*;

class Solution2 {
    private static final boolean LEFT = false, RIGHT = true;

    public static int[] searchForRange(int[] A, int key) {
        int N = A.length;

        return new int[] {
            search(A, key, 0, N - 1, LEFT)
            , search(A, key, 0, N - 1, RIGHT)
        };
    }

    private static int search(int[] A, int key, int lo, int hi, boolean direction) {
        int N = A.length;

        if (hi < lo) { return -1; }

        var mid = lo + (hi - lo) / 2;
        var cmp = Integer.valueOf(key).compareTo(A[mid]);

        if      (cmp < 0) { return search(A, key, lo, mid - 1, direction); }
        else if (0 < cmp) { return search(A, key, mid + 1, hi, direction); }
        else {
            if (direction == LEFT) {
                if (mid == 0 || A[mid - 1] != A[mid])       { return mid; }
                else                                        { return search(A, key, lo, mid - 1, direction); }
            } else {
                if (mid == N - 1 || A[mid] != A[mid + 1])   { return mid; }
                else                                        { return search(A, key, mid + 1, hi, direction); }
            }
        }
    }
}