import java.util.*;

class Solution1 {
	public static String longestSubstringWithoutDuplication(String txt) {
		var N = txt.length();
		var idx = new int[] { 0, 1 };
		var M = new HashMap<Character, Integer>();

		for (int lo = 0, hi = 0; hi < N; hi++) {
			var c = txt.charAt(hi);

			if (M.containsKey(c)) {
				lo = Math.max(lo, M.get(c) + 1);
			}

			if (hi + 1 - lo > idx[1] - idx[0]) {
				idx[0] = lo;
				idx[1] = hi + 1;
			}

			M.put(c, hi);
		}

		return txt.substring(idx[0], idx[1]);
	}
}