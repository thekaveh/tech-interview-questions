package algoexpert.easy.tandem_bicycle;
import java.util.*;

// Approach: TODO.
class Solution3 {
    public int tandemBicycle(int[] R, int[] B, boolean fastest) {
        var T = 0;
        var N = R.length;

        Arrays.sort(R);
        Arrays.sort(B);

        if(fastest) { reverse(B); }

        for(var i = 0; i < N; i++) { T += Math.max(R[i], B[i]); }

        return T;
    }

    private static void reverse(int[] A) {
        var N = A.length;
        
        for(var i = 0; i < N / 2; i++) {
            var T = A[i];
            A[i] = A[N - 1 - i];
            A[N - 1 - i] = T;
        }
    }
}
