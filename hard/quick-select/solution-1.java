import java.util.*;

class Program {
    public static int quickselect(int[] A, int k) {
        var N = A.length;

        var lo = 0;
        var hi = N - 1;

        while(true) {
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

            if      (k - 1 < lt)    { hi = lt - 1; }
            else if (gt < k - 1)    { lo = gt + 1; }
            else                    { return A[lt]; }
        }
    }

    private static void swap(int i, int j, int[] A) {
		var T = A[i];
		A[i] = A[j];
		A[j] = T;
	}
}