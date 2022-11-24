import java.util.*;

class Program {
    public static int[] twoNumberSum(int[] A, int S) {
        var N = A.length;
        var lo = 0;
        var hi = N - 1;
        
        Arrays.sort(A);
        
        while(lo != hi) {
            var T = A[lo] + A[hi];
            
            if		(T < S) { lo++; }
            else if	(T > S)	{ hi--; }
            else			{ return new int[] { A[lo], A[hi] }; }
        }
        
        return new int[0];
    }
}