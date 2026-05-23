package algoexpert.medium.number_of_ways_to_make_change;
import java.util.*;

// Approach: TODO.
class Solution3 {
    // T: O(S * D) | S: O(S * D)
    public static int numberOfWaysToMakeChange(int S, int[] D) {
        var N = D.length;
        var M = new int[N][S + 1];
        
        for(var at = 0; at < N; at++) {
            for(var s = 0; s <= S; s++) {
                if(s == 0) { M[at][s] = 1; continue; }

                int altA = (D[at] <= s) ? M[at][s - D[at]]  : 0;    // inc
                int altB = (1 <= at)    ? M[at - 1][s]      : 0;    // exc
                
                M[at][s] = altA + altB;
            }
        }
        
        return M[N - 1][S];
    }
}
