package educative.patterns.sliding_window.fruits_into_baskets;
import java.util.*;

// Approach: TODO.
class Solution2 {
	public static int findLength(char[] A) {
		int N = A.length, lo = 0, L = 0;
		Map<Character, Integer> M = new HashMap<>();

		for (int hi = 0; hi < N; hi++) {
			char hiC = A[hi];
			M.put(hiC, M.getOrDefault(hiC, 0) + 1);

			while (2 < M.size()) {
				char loC = A[lo++];
				M.put(loC, M.get(loC) - 1);

				if (M.get(loC) == 0) {
					M.remove(loC);
				}
			}

			L = Math.max(L, hi - lo + 1);
		}

		return L;
	}

	public static void main(String[] args) {
		System.out.println("Maximum number of fruits: " +
				Solution2.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
		System.out.println("Maximum number of fruits: " +
				Solution2.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
	}
}
