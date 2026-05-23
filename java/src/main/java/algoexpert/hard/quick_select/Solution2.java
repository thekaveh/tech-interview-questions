package algoexpert.hard.quick_select;
import java.util.*;

// Approach: 3-way partition quickselect (recursive).
class Solution2 {
    public static int quickselect(int[] A, int k) {
        int N = A.length;
        
        if(k < 1 || N < k) { return -1; }

        return quickSelect(A, k - 1, 0, N - 1);
    }
    
    private static int quickSelect(int[] A, int k, int lo, int hi) {
        if(hi < lo) { return -1; }
        
        // pre: A[lo...hi]
        
        var lt = lo;
        var gt = hi;

        var v = A[lo];
        var at = lo + 1;
        
        while(at <= gt) {
            int cmp = Integer.valueOf(A[at]).compareTo(v);
            
            if      (cmp < 0)   { swap(lt++, at++, A); }
            else if (0 < cmp)   { swap(at, gt--, A); }
            else                { at++; }
        }
        
        // post: A[<v: lo..lt-1, =v: lt..gt, >v: gt+1..hi]
        
        if      (k < lt)    { return quickSelect(A, k, lo, lt - 1); }
        else if (gt < k)    { return quickSelect(A, k, gt + 1, hi); }
        else                { return A[lt]; }
    }
    
    private static void swap(int from, int to, int[] A) {
        int T   = A[from];
        A[from] = A[to];
        A[to]   = T;
    }
}
