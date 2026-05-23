package educative.patterns.sliding_window.fruits_into_baskets;
import java.util.*;

// Approach: TODO.
class Solution1 {
	public static int findLength(char[] A) {
		if (A == null || A.length == 0) {
			return -1;
		}

		int N = A.length, lo = 0, hi = 0, ret = -1;
		Set<Character> M = new HashSet<>();

		while (hi < N) {
			while (hi < N && M.size() <= 2) {
				M.add(A[hi++]);
			}
			while (lo <= hi && 2 < M.size()) {
				M.remove(A[lo++]);
			}

			ret = Math.max(ret, hi - lo);
		}

		return ret;
	}

	public static void main(String[] args) {
		System.out.println("Maximum number of fruits: " +
				Solution1.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
		System.out.println("Maximum number of fruits: " +
				Solution1.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
	}
}
