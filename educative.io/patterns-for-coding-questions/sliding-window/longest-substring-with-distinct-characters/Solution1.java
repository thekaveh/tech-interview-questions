import java.util.*;

class NoRepeatSubstring {
	public static int findLength(String txt) {
		int N = txt.length(), lo = 0, L = 0;

		Map<Character, Integer> M = new HashMap<>();

		for (int hi = 0; hi < N; hi++) {
			char hiC = txt.charAt(hi);

			if (M.containsKey(hiC)) {
				lo = Math.max(lo, M.get(hiC) + 1);
			}

			M.put(hiC, hi);

			L = Math.max(L, hi - lo + 1);
		}

		return L;
	}
}