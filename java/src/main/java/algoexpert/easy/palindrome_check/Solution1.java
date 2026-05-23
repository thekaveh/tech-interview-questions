package algoexpert.easy.palindrome_check;
import java.util.*;

// Approach: TODO.
class Solution1 {
    public static boolean isPalindrome(String S) {
        var N = S.length();

        for(var lo = 0; lo < N / 2; lo++) {
            var hi = N - 1 - lo;

            if(S.charAt(lo) != S.charAt(hi)) { return false; }
        }

        return true;
    }
}
