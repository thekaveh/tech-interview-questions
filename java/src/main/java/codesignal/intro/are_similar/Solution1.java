package codesignal.intro.are_similar;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Two-pointer scan allowing at most one swap.
class Solution1 {
    static boolean solution(int[] A, int[] B) {
        var N = A.length;
        
        var lo = 0;
        var hi = N - 1;
        
        var swapped = false;
        
        while(lo <= hi) {
            if      (A[lo] == B[lo]) { lo++; }
            else if (A[hi] == B[hi]) { hi--; }
            else if (A[lo] == B[hi] && A[hi] == B[lo]){
                if(swapped) { return false; }
                
                swap(lo++, hi--, A);
                swapped = true;
            }
            else { return false; }
        }
        
        return true;
    }

    private static void swap(int i, int j, int[] X) {
        var t = X[i];
        X[i] = X[j];
        X[j] = t;
    }
}
