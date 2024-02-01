import java.util.*;

class Solution1 {
    public static int[] quickSort(int[] A) {
        var N = A.length;

        if(N == 0 || N == 1) { return A; }

        quickSort(A, 0, N - 1);

        return A;
    }

    private static void quickSort(int[] A, int lo, int hi) {
        if(lo > hi) { return; }

        // pre: A[lo..hi]

        var lt = lo;
        var gt = hi;
        var v = A[lo];
        var at = lo + 1;

        while(at <= gt) {
            var cmp = Integer.valueOf(A[at]).compareTo(v);

            if      (cmp < 0)   { swap(lt++, at++, A); }
            else if (cmp > 0)   { swap(at, gt--, A); }
            else                { at++; }
        }
        
        // post: A[<v: lo..lt-1, =v: lt..gt, >v: gt+1..hi]

        quickSort(A, lo, lt - 1);
        quickSort(A, gt + 1, hi);
    }

    private static void swap(int i, int j, int[] A) {
		var T = A[i];
		A[i] = A[j];
		A[j] = T;
	}
}