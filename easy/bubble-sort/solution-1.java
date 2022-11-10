import java.util.*;

class Program {
    public static int[] bubbleSort(int[] A) {
        var N = A.length;
        var sorted = true;

        if(N == 0 || N == 1) { return A; }
        
        for(var hi = N - 1; 0 < hi; hi--) {
            for(var lo = 0; lo < hi; lo++) {
                if(A[lo] > A[lo + 1]) {
                    swap(A, lo, lo + 1);

                    sorted = false;
                }
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