package codesignal.thecore.array_replace;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: In-place linear scan with conditional assignment.
class Solution1 {
    static int[] solution(int[] A, int fromElem, int toElem) {
        var N = A.length;
        
        for(var i = 0; i < N; i++) {
            if(A[i] != fromElem) { continue; }
            
            A[i] = toElem;
        }
        
        return A;
    }
}
