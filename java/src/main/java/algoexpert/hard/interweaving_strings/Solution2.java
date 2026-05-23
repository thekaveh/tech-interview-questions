package algoexpert.hard.interweaving_strings;
import java.util.*;

// Approach: TODO.
class Solution2 {
	public static boolean interweavingStrings(String A, String B, String C) {
		var nA = A.length();
		var nB = B.length();
		var M = new Boolean[nA + 1][nB + 1];

		return solve(A, B, C, 0, 0, M);
	}

	private static boolean solve(String A, String B, String C, int atA, int atB, Boolean[][] M) {
		var nA = A.length();
		var nB = B.length();
		var nC = C.length();

		var atC = atA + atB;

		if (atA == nA && atB == nB && atC == nC) {
			return true;
		}
		if (atC == nC) {
			return false;
		}
		if (M[atA][atB] != null) {
			return M[atA][atB];
		}

		var altA = (atA < nA && A.charAt(atA) == C.charAt(atC)) && solve(A, B, C, atA + 1, atB, M);
		var altB = (atB < nB && B.charAt(atB) == C.charAt(atC)) && solve(A, B, C, atA, atB + 1, M);

		return M[atA][atB] = altA || altB;
	}
}
