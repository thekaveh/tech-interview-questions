package algoexpert.hard.min_number_of_jumps;
import java.util.*;

// Approach: Bottom-up DP (forward pass updating reachable cells).
class Solution1 {
	public static int minNumberOfJumps(int[] A) {
		int N = A.length;
		var M = new int[N];

		for (var i = 1; i < N; i++) {
			M[i] = Integer.MAX_VALUE;
		}

		for (var lo = 0; lo < N - 1; lo++) {
			for (var hi = lo + 1; hi <= lo + A[lo] && hi < N; hi++) {
				M[hi] = Math.min(M[hi], 1 + M[lo]);
			}
		}

		return M[N - 1];
	}
}
