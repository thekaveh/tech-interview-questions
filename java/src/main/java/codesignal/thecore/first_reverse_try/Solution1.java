package codesignal.thecore.first_reverse_try;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Single swap of indices 0 and N-1 using a temp variable.
class Solution1 {
    static int[] solution(int[] A) {
        var N = A.length;
        
        if(N == 0) { return A; }
        
        swap(A, 0, N - 1);
        
        return A;
    }
    
    static void swap(int[] A, int i, int j) {
        var t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
}
