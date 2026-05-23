package algoexpert.medium.longest_palindromic_substring;
import java.util.*;

// Approach: Top-down DP memoization on (lo, hi) substrings.
class Solution3 {
    public static String longestPalindromicSubstring(String txt) {
        var N = txt.length();
        var M = new TextInfo[N][N];

        var ret = solve(txt, 0, N - 1, M);

        return txt.substring(ret.idx, ret.idx + ret.len);
    }

    private static TextInfo solve(String txt, int lo, int hi, TextInfo[][] M) {
        if (lo > hi) {
            return new TextInfo(-1, 0);
        }
        if (lo == hi) {
            return new TextInfo(lo, 1);
        }
        if (M[lo][hi] != null) {
            return M[lo][hi];
        }

        if (txt.charAt(lo) == txt.charAt(hi)) {
            var T = solve(txt, lo + 1, hi - 1, M);

            if (2 + T.len == hi - lo + 1) {
                return M[lo][hi] = new TextInfo(lo, 2 + T.len);
            }
        }

        var altA = solve(txt, lo + 1, hi, M);
        var altB = solve(txt, lo, hi - 1, M);

        return M[lo][hi] = (altA.len >= altB.len) ? altA : altB;
    }

    static class TextInfo {
        int idx;
        int len;

        TextInfo(int idx, int len) {
            this.idx = idx;
            this.len = len;
        }
    }
}
