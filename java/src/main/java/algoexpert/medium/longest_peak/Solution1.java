package algoexpert.medium.longest_peak;
import java.util.*;

// Approach: TODO.
class Solution1 {
	public static int longestPeak(int[] A) {
		var R = 0;
		var N = A.length;
		
		for(var lo = 0; lo < N - 2; lo++) {
			for(var tip = lo + 1; tip < N - 1 && A[tip - 1] < A[tip]; tip++) {
				for(var hi = tip + 1; hi < N && A[hi - 1] > A[hi]; hi++) {
					var L = hi - lo + 1;
					
					if(L < 3) { continue; }
					
					R = Math.max(R, L);
				}
			}
		}
		
		return R;
	}
}
