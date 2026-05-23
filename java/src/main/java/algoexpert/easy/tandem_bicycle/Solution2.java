package algoexpert.easy.tandem_bicycle;
import java.util.*;

// Approach: Sort both, ternary index selection.
class Solution2 {
    public int tandemBicycle(int[] A, int[] B, boolean fastest) {
        var N = A.length;

        Arrays.sort(A);
        Arrays.sort(B);

        var S = 0;

        for(var i = 0; i < N; i++) {
            S += fastest ? Math.max(A[i], B[N-1-i]) : Math.max(A[i], B[i]);
        }

        return S;
    }
}
