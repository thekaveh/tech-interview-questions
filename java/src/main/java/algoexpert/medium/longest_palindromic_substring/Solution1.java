package algoexpert.medium.longest_palindromic_substring;
import java.util.*;

// Approach: TODO.
class Solution1 {
    public static String longestPalindromicSubstring(String txt) {
        var R = "";
        var N = txt.length();

        for(var lo = 0; lo < N; lo++) {
            for(var hi = lo; hi < N; hi++) {
                if(!isPalindrome(txt, lo, hi)) { continue; }

                if(hi - lo + 1 > R.length()) { R = txt.substring(lo, hi + 1); }
            }
        }

        return R;
    }

    private static boolean isPalindrome(String txt, int lo, int hi) {
        while(lo <= hi) {
            if(txt.charAt(lo) != txt.charAt(hi)) { return false; }

            lo++;
            hi--;
        }

        return true;
    }
}
