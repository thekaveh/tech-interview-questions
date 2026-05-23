package codesignal.thecore.concatenate_arrays;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Manual index-tracked loop copying A then B into result array.
class Solution1 {
    static int[] solution(int[] A, int[] B) {
        var M = A.length;
        var N = B.length;
        
        var idx = 0;
        var R = new int[M + N];
        
        for(var a : A) { R[idx++] = a; }
        for(var b : B) { R[idx++] = b; }
        
        return R;
    } 
}
