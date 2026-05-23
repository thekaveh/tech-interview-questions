package algoexpert.easy.bubble_sort;
import java.util.*;

// Approach: TODO.
class Solution1 {
    public static int[] bubbleSort(int[] A) {
        var N = A.length;

        if(N == 0 || N == 1) { return A; }
        
        for(var hi = N - 1; 0 < hi; hi--) {
            var sorted = true;

            for(var lo = 0; lo < hi; lo++) {
                if(A[lo] <= A[lo + 1]) { continue; }

				sorted = false;
				swap(A, lo, lo + 1);
            }

            if(sorted) { break; }
        }

        return A;
    }

    private static void swap(int[] A, int i, int j) {
        int T = A[i];
        A[i] = A[j];
        A[j] = T;
    }
}
