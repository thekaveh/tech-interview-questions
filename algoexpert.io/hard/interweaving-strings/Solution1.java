import java.util.*;

class Solution1 {
	public static boolean interweavingStrings(String A, String B, String C) {
		var nA = A.length();
		var nB = B.length();
		var nC = C.length();

		if (nA + nB != nC) {
			return false;
		}

		var M = new boolean[nA + 1][nB + 1];
		M[0][0] = true;

		for (var atA = 1; atA <= nA; atA++) {
			M[atA][0] = M[atA - 1][0] && A.charAt(atA - 1) == C.charAt(atA - 1);
		}

		for (var atB = 1; atB <= nB; atB++) {
			M[0][atB] = M[0][atB - 1] && B.charAt(atB - 1) == C.charAt(atB - 1);
		}

		for (var atA = 1; atA <= nA; atA++) {
			for (var atB = 1; atB <= nB; atB++) {
				var atC = atA + atB;

				var altA = A.charAt(atA - 1) == C.charAt(atC - 1) && M[atA - 1][atB];
				var altB = B.charAt(atB - 1) == C.charAt(atC - 1) && M[atA][atB - 1];

				M[atA][atB] = altA || altB;
			}
		}

		return M[nA][nB];
	}
}