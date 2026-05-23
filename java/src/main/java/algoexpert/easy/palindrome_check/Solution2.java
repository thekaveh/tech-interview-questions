package algoexpert.easy.palindrome_check;
import java.util.*;

// Approach: TODO.
class Solution2 {
    public static boolean isPalindrome(String S) {
        var N = S.length();

        for(int lo = 0, hi = N - 1; lo < hi; lo++, hi--) {
            if(S.charAt(lo) != S.charAt(hi)) { return false; }
        }

        return true;
    }
}
