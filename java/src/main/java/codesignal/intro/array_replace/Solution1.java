package codesignal.intro.array_replace;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static int[] solution(int[] A, int from, int to) {
        var N = A.length;
        
        for(var i = 0; i < N; i++) {
            if(A[i] != from) { continue; }
            
            A[i] = to;
        }
        
        return A;
    }
}
