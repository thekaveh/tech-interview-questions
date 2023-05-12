import java.util.*;

class Solution1 {
    public static int[] selectionSort(int[] A) {
        var N = A.length;

        if(N == 0 || N == 1) { return A; }

        for(var i = 0; i < N; i++) {
            var min = i;

            for(var j = i + 1; j < N; j++) {
                if(A[j] < A[min]) { min = j; }
            }

            swap(A, i, min);
        }

        return A;
    }

    private static void swap(int[] A, int i, int j) {
        int T = A[i];
        A[i] = A[j];
        A[j] = T;
    }
}