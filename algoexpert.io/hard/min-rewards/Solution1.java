import java.util.*;

class Solution1 {
	public static int minRewards(int[] A) {
		var N = A.length;
		var M = new int[N];

		Arrays.fill(M, 1);

		for (var at = 1; at < N; at++) {
			if (A[at - 1] < A[at]) {
				M[at] = M[at - 1] + 1;
			}
		}

		for (var at = N - 2; 0 <= at; at--) {
			if (A[at + 1] < A[at]) {
				M[at] = Math.max(M[at], M[at + 1] + 1);
			}
		}

		return Arrays.stream(M).sum();
	}
}
