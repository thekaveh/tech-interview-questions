import java.util.*;

class Program {
    public static int quickselect(int[] A, int k) {
        int N = A.length;
        
        return quickSelect(A, k - 1, 0, N - 1);
    }
	
	private static int quickSelect(int[] A, int k, int lo, int hi) {
        if(lo > hi) { return -1; }
        
		// pre: A[lo...hi]
		
		var lt = lo;
		var gt = hi;
		var v = A[lo];
		var i = lo + 1;
		
		while(i <= gt) {
			int cmp = Integer.valueOf(A[i]).compareTo(v);
			
			if	    (cmp < 0)   { swap(lt++, i++, A); }
			else if (cmp > 0)   { swap(i, gt--, A); }
			else 			    { i++; }
		}
		
		// post: A[lo...lt-1] < v = A[lt...gt] < A[gt+1...hi]
		
		if		(k < lt)    { return quickSelect(A, k, lo, lt - 1); }
		else if	(gt < k) 	{ return quickSelect(A, k, gt + 1, hi); }
		else 				{ return A[lt]; }
	}
	
	private static void swap(int from, int to, int[] A) {
		int T 	= A[from];
		A[from] = A[to];
		A[to] 	= T;
	}
}