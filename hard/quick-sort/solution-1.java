import java.util.*;

class Program {
    public static int[] quickSort(int[] A) {
        var N = A.length;

        if(N == 0 || N == 1) { return A; }

        quickSort(A, 0, N - 1);

        return A;
    }

    private static void quickSort(int[] A, int lo, int hi) {
        if(lo > hi) { return; }

        // pre: A[lo...hi]

        var lt = lo;
        var gt = hi;
        var v = A[lo];
        var i = lo + 1;

        while(i <= gt) {
            var cmp = Integer.valueOf(A[i]).compareTo(v);

            if      (cmp < 0)   { swap(lt++, i++, A); }
            else if (cmp > 0)   { swap(i, gt--, A); }
            else                { i++; }
        }

        // post: A[lo...lt-1] < v = A[lt...gt] < A[gt+1...hi]

        quickSort(A, lo, lt - 1);
        quickSort(A, gt + 1, hi);
    }

    private static void swap(int i, int j, int[] A) {
		var T = A[i];
		A[i] = A[j];
		A[j] = T;
	}
}