import java.util.*;

class Program {
    public static boolean isPalindrome(String S) {
        var N = S.length();

        for(int lo = 0, hi = N - 1; lo < hi; lo++, hi--) {
            if(S.charAt(lo) != S.charAt(hi)) { return false; }
        }

        return true;
    }
}