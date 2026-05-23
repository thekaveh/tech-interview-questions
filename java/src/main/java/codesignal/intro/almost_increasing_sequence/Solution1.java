package codesignal.intro.almost_increasing_sequence;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static boolean solution(int[] A) {
        var N = A.length;
        var attempt = false;
        
        for(var i = 1; i < N; i++) {
            if(A[i - 1] < A[i]) { continue; }
            
            if(attempt) { return false; }
            
            if(i - 2 >= 0 && !(A[i - 2] < A[i]) && i + 1 < N && !(A[i - 1] < A[i + 1])) {
                return false;
            }
            
            attempt = true;
        }
        
        return true;
    }
}
