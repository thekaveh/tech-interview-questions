package algoexpert.hard.quick_select;
import java.util.*;

// Approach: 3-way partition quickselect (iterative).
class Solution1 {
    public static int quickselect(int[] A, int k) {
        var N = A.length;
        
        if(k < 1 || N < k) { return -1; }

        var lo = 0;
        var hi = N - 1;

        while(lo <= hi) {
            // pre: A[lo...hi]

            var lt = lo;
            var gt = hi;

            var v = A[lo];
            var at = lo + 1;

            while(at <= gt) {
                var cmp = Integer.valueOf(A[at]).compareTo(v);

                if      (cmp < 0)   { swap(lt++, at++, A); }
                else if (0 < cmp)   { swap(at, gt--, A); }
                else                { at++; }
            }

            // post: A[<v: lo..lt-1, =v: lt..gt, >v: gt+1..hi]

            if      (k - 1 < lt)    { hi = lt - 1; }
            else if (gt < k - 1)    { lo = gt + 1; }
            else                    { return A[lt]; }
        }

        return -1;
    }

    private static void swap(int i, int j, int[] A) {
        var T = A[i];
        A[i] = A[j];
        A[j] = T;
    }
}
