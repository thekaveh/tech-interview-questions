package algoexpert.medium.levenshtein_distance;
import java.util.*;

// Approach: Top-down recursion with 2-D memoization (shrinking suffixes).
class Solution1 {
    // T: O(A * B) | S: O(A * B)
    public static int levenshteinDistance(String strA, String strB) {
        var A = strA.length();
        var B = strB.length();

        var M = new Integer[A + 1][B + 1];

        return solve(strA, strB, 0, 0, M);
    }

    // shrinking suffixes
    private static int solve(String strA, String strB, int atA, int atB, Integer[][] M) {
        if (M[atA][atB] != null) {
            return M[atA][atB];
        }

        var A = strA.length();
        var B = strB.length();

        if (atA == A) {
            M[atA][atB] = B - atB;
        } else if (atB == B) {
            M[atA][atB] = A - atA;
        } else if (strA.charAt(atA) == strB.charAt(atB)) {
            M[atA][atB] = solve(strA, strB, atA + 1, atB + 1, M);
        } else {
            var altA = solve(strA, strB, atA + 1, atB, M) + 1;
            var altB = solve(strA, strB, atA, atB + 1, M) + 1;
            var altC = solve(strA, strB, atA + 1, atB + 1, M) + 1;

            M[atA][atB] = Math.min(altA, Math.min(altB, altC));
        }

        return M[atA][atB];
    }
}
