import java.util.*;

class Solution2 {
	public static String longestPalindromicSubstring(String txt) {
		var N = txt.length();

		if (N == 1) {
			return txt;
		}

		var longest = new int[] { 0, 1 };

		for (var at = 1; at < N; at++) {
			var odd = solve(txt, at - 1, at + 1);
			var even = solve(txt, at - 1, at);

			var longer = (odd[1] - odd[0] > even[1] - even[0]) ? odd : even;
			longest = (longer[1] - longer[0] > longest[1] - longest[0]) ? longer : longest;
		}

		return txt.substring(longest[0], longest[1]);
	}

	private static int[] solve(String txt, int lo, int hi) {
		var N = txt.length();

		while (0 <= lo && hi < N) {
			if (txt.charAt(lo) != txt.charAt(hi)) {
				break;
			}

			lo--;
			hi++;
		}

		return new int[] { lo + 1, hi };
	}
}