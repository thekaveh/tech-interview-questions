package algoexpert.hard.subarray_sort;
import java.util.*;

// Approach: TODO.
class Solution1 {
	public static int[] subarraySort(int[] A) {
		var N = A.length;

		var minOoO = Integer.MAX_VALUE;
		var maxOoO = Integer.MIN_VALUE;

		for (var i = 0; i < N; i++) {
			if (0 < i && A[i] < A[i - 1]) 		{ minOoO = Math.min(minOoO, A[i]); }
			if (i < N - 1 && A[i + 1] < A[i]) 	{ maxOoO = Math.max(maxOoO, A[i]); }
		}

		if (minOoO == Integer.MAX_VALUE && maxOoO == Integer.MIN_VALUE) { return new int[] { -1, -1 }; }

		var R = new int[] { 0, N - 1 };

		for (; R[0] < N && A[R[0]] <= minOoO; R[0]++);
		for (; 0 <= R[1] && maxOoO <= A[R[1]]; R[1]--);

		return R;
	}
}
