package algoexpert.hard.longest_subarray_with_sum;
import java.util.*;

// Approach: TODO.
class Solution1 {
	public int[] longestSubarrayWithSum(int[] A, int S) {
		var N = A.length;
		var R = new int[0];

		var T = 0;
		var lo = 0;
		var hi = 0;

		while (hi < N) {
			T += A[hi];

			while (lo < hi && S < T) {
				T -= A[lo++];
			}

			if (T == S) {
				if (R.length == 0 || R[1] - R[0] < hi - lo) {
					R = new int[] { lo, hi };
				}
			}

			hi++;
		}

		return R;
	}
}
