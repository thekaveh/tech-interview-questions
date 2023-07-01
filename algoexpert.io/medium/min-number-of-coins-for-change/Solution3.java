import java.util.*;

class Solution3 {
    public static int minNumberOfCoinsForChange(int S, int[] D) {
        var N = D.length;
        var M = new Integer[N][S + 1];

        for(var at = 0; at < N; at++) {
            for(var s = 0; s <= S; s++) {
                if(s == 0) { M[at][s] = 0; continue; }

                var altA = (1 <= at) ? M[at - 1][s] : Integer.MAX_VALUE;
                var altB = (D[at] <= s && M[at][s - D[at]] != Integer.MAX_VALUE)
                    ? 1 + M[at][s - D[at]]
                    : Integer.MAX_VALUE;
                
                M[at][s] = Math.min(altA, altB);
            }
        }
        
        return (M[N - 1][S] != Integer.MAX_VALUE) ? M[N - 1][S] : -1;
    }
}