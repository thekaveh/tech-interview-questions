import java.util.*;

class Program {
    public static int minNumberOfCoinsForChange(int S, int[] D) {
        var N = D.length;
        var M = new Integer[N][S + 1];
        
        for(var d = 0; d < N; d++) {
            for(var s = 0; s <= S; s++) {
                if(s == 0) { M[d][s] = 0; continue; }

                var altA = (1 <= d) ? M[d - 1][s] : Integer.MAX_VALUE;
                var altB = (D[d] <= s && M[d][s - D[d]] != Integer.MAX_VALUE)
                    ? 1 + M[d][s - D[d]]
                    : Integer.MAX_VALUE;
                
                M[d][s] = Math.min(altA, altB);
            }
        }
        
        return (M[N - 1][S] != Integer.MAX_VALUE) ? M[N - 1][S] : -1;
    }
}