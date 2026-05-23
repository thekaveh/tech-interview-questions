package algoexpert.hard.maximize_expression;
import java.util.*;

// Approach: TODO.
class Solution2 {
	public int maximizeExpression(int[] A) {
		var N = A.length;

		if (N < 4) {
			return 0;
		}

		var M1 = new int[N];
		var M2 = new int[N];
		var M3 = new int[N];
		var M4 = new int[N];

		Arrays.fill(M1, Integer.MIN_VALUE);
		Arrays.fill(M2, Integer.MIN_VALUE);
		Arrays.fill(M3, Integer.MIN_VALUE);
		Arrays.fill(M4, Integer.MIN_VALUE);

		M1[0] = A[0];
		for (var at = 1; at < N - 3; at++) {
			M1[at] = Math.max(M1[at - 1], A[at]);
		}
		for (var at = 1; at < N - 2; at++) {
			M2[at] = Math.max(M2[at - 1], M1[at - 1] - A[at]);
		}
		for (var at = 2; at < N - 1; at++) {
			M3[at] = Math.max(M3[at - 1], M2[at - 1] + A[at]);
		}
		for (var at = 3; at < N; at++) {
			M4[at] = Math.max(M4[at - 1], M3[at - 1] - A[at]);
		}

		return M4[N - 1];
	}
}
