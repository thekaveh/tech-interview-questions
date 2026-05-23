package educative.patterns.sliding_window.longest_subarray_with_ones_after_replacement;
import java.util.*;

// Approach: Variable-size sliding window tracking max ones seen; shrink when zeros in window exceed k.
class Solution1 {
	public static int findLength(int[] A, int k) {
		int N = A.length;
		int L = 0;
		int lo = 0;
		int max = 0;

		for (int hi = 0; hi < N; hi++) {
			if (A[hi] == 1) {
				max++;
			}

			if (k < hi - lo + 1 - max) {
				if (A[lo++] == 1) {
					max--;
				}
			}

			L = Math.max(L, hi - lo + 1);
		}

		return L;
	}
}
