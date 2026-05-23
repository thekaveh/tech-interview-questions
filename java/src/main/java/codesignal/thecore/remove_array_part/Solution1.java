package codesignal.thecore.remove_array_part;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Manually copy elements before lo and after hi into a new array.
class Solution1 {
    static int[] solution(int[] A, int lo, int hi) {
        var M = A.length;
        var N = M - (hi - lo + 1);
        
        var idx = 0;
        var R = new int[N];
        
        for(var i = 0; i < lo; i++)     { R[idx++] = A[i]; }
        for(var i = hi + 1; i < M; i++) { R[idx++] = A[i]; }
        
        return R;
    }
}
