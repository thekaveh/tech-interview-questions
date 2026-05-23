package algoexpert.medium.three_number_sum;
import java.util.*;

// Approach: Sort + outer loop with inner two-pointer.
class Solution2 {
    public static List<Integer[]> threeNumberSum(int[] A, int S) {
        var N = A.length;
        var R = new ArrayList<Integer[]>();
            
        Arrays.sort(A);
        
        for(var i = 0; i < N - 2; i++) {
            var lo = i + 1;
            var hi = N - 1;
            
            while(lo < hi) {
                int T = A[i] + A[lo] + A[hi];
                
                if	    (T < S) { lo++; }
                else if	(S < T) { hi--; }
                else {
                    R.add(new Integer[] { A[i], A[lo], A[hi] });
                    
                    lo++;
                    hi--;
                }
            }
        }
        
        return R;
    }
}
