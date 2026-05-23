package educative.patterns.sliding_window.find_permutation_in_a_string;
import java.util.*;

// Approach: Fixed-size sliding window with character frequency map and matched-count tracking.
class Solution1 {
	public static boolean findPermutation(String txt, String pattern) {
		int N = txt.length(), M = pattern.length(), lo = 0, matched = 0;

		Map<Character, Integer> FREQ = new HashMap<>();

		for (char c : pattern.toCharArray()) {
			FREQ.put(c, FREQ.getOrDefault(c, 0) + 1);
		}

		for (int hi = 0; hi < N; hi++) {
			char hiC = txt.charAt(hi);

			if (FREQ.containsKey(hiC)) {
				FREQ.put(hiC, FREQ.get(hiC) - 1);

				if (FREQ.get(hiC) == 0) {
					matched++;
				}
			}

			if (matched == FREQ.size()) {
				return true;
			}

			if (M <= hi - lo + 1) {
				char loC = txt.charAt(lo++);

				if (FREQ.containsKey(loC)) {
					if (FREQ.get(loC) == 0) {
						matched--;
					}
					FREQ.put(loC, FREQ.get(loC) + 1);
				}
			}
		}

		return false;
	}
}
