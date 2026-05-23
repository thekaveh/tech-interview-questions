package codesignal.intro.array_change;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static int solution(int[] A) {
        var N = A.length;
        
        var R = 0;
        
        for(var i = 1; i < N; i++) {
            if(A[i - 1] < A[i]) { continue; }
            
            var diff = A[i - 1] - A[i] + 1;
            
            R += diff;
            A[i] += diff;
        }
        
        return R;
    }
}
