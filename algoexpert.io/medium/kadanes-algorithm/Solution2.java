import java.util.*;

class Solution2 {
    public static int kadanesAlgorithm(int[] A) {
        var N = A.length;
        var T = A[0];
        var S = A[0];

        for(var i = 1; i < N; i++) {
            T = Math.max(A[i], T + A[i]);
            S = Math.max(S, T);
        }

        return S;
    }
}