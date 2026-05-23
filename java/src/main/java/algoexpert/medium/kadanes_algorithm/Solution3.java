package algoexpert.medium.kadanes_algorithm;
import java.util.*;

// Approach: TODO.
class Solution3 {
	public static int kadanesAlgorithm(int[] A) {
		var N = A.length;

		var M = new int[2];
		M[0] = A[0];
		M[1] = A[0];

		for (var i = 1; i < N; i++) {
			M[0] = Math.max(A[i], M[0] + A[i]);
			M[1] = Math.max(M[0], M[1]);
		}

		return M[1];
	}
}
