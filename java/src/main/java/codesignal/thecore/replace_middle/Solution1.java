package codesignal.thecore.replace_middle;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static int[] solution(int[] A) {
        var N = A.length;
        
        if(N % 2 == 1) { return A; }
        
        var idx = 0;
        var R = new int[N - 1];
        
        for(var i = 0; i < N / 2 - 1; i++) { R[idx++] = A[i]; }
        R[idx++] = A[N / 2 - 1] + A[N / 2];
        for(var i = N / 2 + 1; i < N; i++) { R[idx++] = A[i]; }
        
        return R;
    }
}
