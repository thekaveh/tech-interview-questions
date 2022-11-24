import java.util.*;

class Program {
    // T: O(S * D) | S: O(S * D)
    public static int numberOfWaysToMakeChange(int S, int[] D) {
        int N = D.length;
        Integer[][] M = new Integer[N][S + 1];
        
        for(int d = 0; d < N; d++) {
            for(int s = 0; s <= S; s++) {
                if(s == 0) { M[d][s] = 1; continue; }

                int altA = (D[d] <= s) ? M[d][s - D[d]] : 0;    // inc
                int altB = (1 <= d) ? M[d - 1][s] : 0; 		    // exc
                
                M[d][s] = altA + altB;
            }
        }
        
        return M[N - 1][S];
    }
}