package codesignal.thecore.concatenate_arrays;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: System.arraycopy for each segment in bulk.
class Solution2 {
    static int[] solution(int[] A, int[] B) {
        var M = A.length;
        var N = B.length;
        
        var R = new int[M + N];
        
        System.arraycopy(A, 0, R, 0, M);
        System.arraycopy(B, 0, R, M, N);
        
        return R;
    } 
}
