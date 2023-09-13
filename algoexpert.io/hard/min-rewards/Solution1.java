import java.util.*;

class Solution1 {
    public static int minRewards(int[] S) {
        var N = S.length;

        var M = new int[N];
        Arrays.fill(M, 1);

        for (var i = 1; i < N; i++) {
            if (S[i - 1] < S[i]) {
                M[i] = M[i - 1] + 1;
            }
        }

        for (var i = N - 2; 0 <= i; i--) {
            if (S[i + 1] < S[i]) {
                M[i] = Math.max(M[i], M[i + 1] + 1);
            }
        }

        var ret = 0;
        for (var i = 0; i < N; i++) { ret += M[i]; }
        return ret;
    }
}