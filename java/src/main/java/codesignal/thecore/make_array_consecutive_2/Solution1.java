package codesignal.thecore.make_array_consecutive_2;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Sort then sum the gaps between adjacent elements.
class Solution1 {
    static int solution(int[] A) {
        var ret = 0;
        var N = A.length;
        
        Arrays.sort(A);
        
        for(var i = 1; i < N; i++) {
            if(A[i] - A[i - 1] == 1) { continue; }
            
            ret += A[i] - A[i - 1] - 1;
        }
        
        return ret;
    }
}
