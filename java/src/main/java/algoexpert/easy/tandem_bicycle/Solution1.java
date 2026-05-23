package algoexpert.easy.tandem_bicycle;
import java.util.*;

// Approach: Sort both, pair with mirrored index if fastest.
class Solution1 {
    public int tandemBicycle(int[] R, int[] B, boolean fastest) {
        var T = 0;
        var N = R.length;

        Arrays.sort(R);
        Arrays.sort(B);

        for(var i = 0; i < N; i++) {
            if(fastest) { T += Math.max(R[i], B[N - 1 - i]); }
            else        { T += Math.max(R[i], B[i]); }
        }

        return T;
    }
}
