import java.util.*;

class Program {
    public static int quickselect(int[] A, int k) {
        var N = A.length;
        
        if(k < 1 || N < k) { return -1; }

        var lo = 0;
        var hi = N - 1;

        while(true) {
            // pre: A[lo...hi]

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

            // post: A[<v: lo..lt-1, v: lt..gt, >v: gt+1..hi]

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