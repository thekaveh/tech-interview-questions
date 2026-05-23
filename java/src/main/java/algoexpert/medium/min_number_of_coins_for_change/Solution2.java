package algoexpert.medium.min_number_of_coins_for_change;
import java.util.*;

// Approach: Top-down recursion with 2-D memoization.
class Solution2 {
    public static int minNumberOfCoinsForChange(int S, int[] D) {
        var N = D.length;
        var M = new Integer[N][S + 1];

        var t = solve(S, D, 0, M);
        
        return (t != Integer.MAX_VALUE) ? t : -1;
    }
    
    private static int solve(int S, int[] D, int at, Integer[][] M) {
        var N = D.length;
        
        if(S == 0)              { return 0; }
        if(N == 0 || N <= at)   { return Integer.MAX_VALUE; }

        if(M[at][S] != null) { return M[at][S]; }
        
        // exclude
        var altA = solve(S, D, at + 1, M);
        
        // include
        var altB = Integer.MAX_VALUE;       
        if(D[at] <= S) {
            var t = solve(S - D[at], D, at, M);
            
            if(t != Integer.MAX_VALUE) { altB = 1 + t; }
        }
        
        return M[at][S] = Math.min(altA, altB);
    }
}
