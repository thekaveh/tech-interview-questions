import java.util.*;

class Solution1 {
	public static List<Character> longestCommonSubsequence(String strA, String strB) {
		var nA = strA.length();
		var nB = strB.length();

		var dp = new int[nA + 1][nB + 1];

		for (var atA = 1; atA <= nA; atA++) {
			for (var atB = 1; atB <= nB; atB++) {
				if (strA.charAt(atA - 1) == strB.charAt(atB - 1)) {
					dp[atA][atB] = 1 + dp[atA - 1][atB - 1];
				} else {
					dp[atA][atB] = Math.max(dp[atA - 1][atB], dp[atA][atB - 1]);
				}
			}
		}

		var result = new ArrayList<Character>();

		for (int atA = nA, atB = nB; 0 < atA && 0 < atB;) {
			if (dp[atA][atB] == dp[atA - 1][atB]) {
				atA--;
			} else if (dp[atA][atB] == dp[atA][atB - 1]) {
				atB--;
			} else if (dp[atA][atB] == 1 + dp[atA - 1][atB - 1]) {
				result.add(0, strA.charAt(atA - 1));
				atA--;
				atB--;
			}
		}

		return result;
	}
}
