package codesignal.intro.check_palindrome;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Two-pointer inward scan.
class Solution1 {
    static boolean solution(String txt) {
        var N = txt.length();
        
        for(int lo = 0, hi = N - 1; lo <= hi; lo++, hi--) {
            if(txt.charAt(lo) != txt.charAt(hi)) { return false; }
        }
        
        return true;
    }
}
