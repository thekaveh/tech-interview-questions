package algoexpert.medium.first_duplicate_value;
import java.util.*;

// Approach: TODO.
class Solution2 {
    public int firstDuplicateValue(int[] A) {
        for(var a : A) {
            if(isMarked(a, A)) { return unmarked(a); }

            mark(a, A);
        }

        return -1;
    }

    private static boolean isMarked(int a, int[] A) {
        var idx = Math.abs(a) - 1;

        return A[idx] < 0;
    }

    private static void mark(int a, int[] A) {
        var idx = Math.abs(a) - 1;

        A[idx] *= -1;
    }

    private static int unmarked(int a) {
        return Math.abs(a);
    }
}
