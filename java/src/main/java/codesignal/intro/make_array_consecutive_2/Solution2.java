package codesignal.intro.make_array_consecutive_2;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution2 {
    static int solution(int[] A) {
        var M = A.length;
        
        Arrays.sort(A);
        
        var N = A[M - 1] - A[0] + 1;
        
        return N - M;
    }
}
