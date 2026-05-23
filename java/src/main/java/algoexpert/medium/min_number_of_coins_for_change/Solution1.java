package algoexpert.medium.min_number_of_coins_for_change;
import java.util.*;

// Approach: TODO.
class Solution1 {
    public static int minNumberOfCoinsForChange(int S, int[] D) {
        var t = solve(S, D, 0);
        
        return (t != Integer.MAX_VALUE) ? t : -1;
    }
	
	private static int solve(int S, int[] D, int at) {
		var N = D.length;
		
		if(S == 0)              { return 0; }
		if(N == 0 || N <= at)   { return Integer.MAX_VALUE; }
		
		// exclude
		var altA = solve(S, D, at + 1);
		
		// include
		var altB = Integer.MAX_VALUE;		
		if(D[at] <= S) {
			var t = solve(S - D[at], D, at);
			
			if(t != Integer.MAX_VALUE) { altB = 1 + t; }
		}
		
		return Math.min(altA, altB);
	}
}
