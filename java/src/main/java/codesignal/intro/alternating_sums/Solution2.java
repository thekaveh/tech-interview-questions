package codesignal.intro.alternating_sums;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Single pass using index parity into two-element result.
class Solution2 {
    static int[] solution(int[] A) {
        var N = A.length;

        var R = new int[2];
        
        for(var i = 0; i < N; i++) { R[i % 2] += A[i]; }
        
        return R;
    }
}
