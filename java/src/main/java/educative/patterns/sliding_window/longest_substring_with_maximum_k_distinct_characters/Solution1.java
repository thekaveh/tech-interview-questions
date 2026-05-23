package educative.patterns.sliding_window.longest_substring_with_maximum_k_distinct_characters;
import java.util.*;

// Approach: TODO.
class Solution1 {
	public static int findLength(String input, int k) {
		if (input == null || input.length() == 0) {
			throw new IllegalArgumentException();
		}

		int N = input.length(), lo = 0, L = 0;
		Map<Character, Integer> M = new HashMap<>();

		for (int hi = 0; hi < N; hi++) {
			char hiC = input.charAt(hi);
			M.put(hiC, M.getOrDefault(hiC, 0) + 1);

			while (k < M.size()) {
				char loC = input.charAt(lo++);
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
		System.out.println("Length of the longest substring: " + Solution1.findLength("araaci", 2));
		System.out.println("Length of the longest substring: " + Solution1.findLength("araaci", 1));
		System.out.println("Length of the longest substring: " + Solution1.findLength("cbbebi", 3));
	}
}
