import java.util.*;

class Solution2 {
	public static int maxSubsetSumNoAdjacent(int[] A) {
		var N = A.length;

		if (N == 0) {
			return 0;
		}
		if (N == 1) {
			return A[0];
		}

		var M = new int[2];
		M[0] = A[0];
		M[1] = Math.max(A[0], A[1]);

		for (var i = 2; i < N; i++) {
			var t = Math.max(M[1], M[0] + A[i]);
			M[0] = M[1];
			M[1] = t;
		}

		return M[1];
	}
}