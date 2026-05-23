package algoexpert.easy.palindrome_check;
import java.util.*;

// Approach: TODO.
class Solution3 {
    public static boolean isPalindrome(String S) {
        return isPalindrome(S, 0);
    }

    private static boolean isPalindrome(String S, int lo) {
        var N = S.length();
        var hi = N - 1 - lo;

        if(lo >= hi) { return true; }

        return S.charAt(lo) == S.charAt(hi) && isPalindrome(S, lo + 1);
    }
}
