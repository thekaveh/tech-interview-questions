package codesignal.intro.build_palindrome;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Grow suffix boundary until palindrome, then append reversed prefix.
class Solution2 {
    static String solution(String txt) {
        var N = txt.length();

        var hi = 0; while(hi < N && !isPalindrome(hi, N - 1, txt)) { hi++; }

        return txt + new StringBuilder(txt.substring(0, hi)).reverse().toString();
    }

    static boolean isPalindrome(int lo, int hi, String txt) {
        while(lo <= hi) {
            if(txt.charAt(lo++) != txt.charAt(hi--)) { return false; }
        }
        
        return true;
    }
}
