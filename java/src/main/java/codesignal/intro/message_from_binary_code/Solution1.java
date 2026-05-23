package codesignal.intro.message_from_binary_code;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static String solution(String txt) {
        var N = txt.length();
        var R = new StringBuilder();
        
        for(var lo = 0; lo < N; lo += 8) {
            var byteVal = Integer.parseInt(txt.substring(lo, lo + 8), 2);
            
            R.append((char)byteVal);
        }
        
        return R.toString();
    }
}
