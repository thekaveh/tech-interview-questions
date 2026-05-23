package codesignal.intro.longest_digits_prefix;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Linear scan until first non-digit, then substring.
class Solution1 {
    static String solution(String txt) {
        var N = txt.length();

        for(var i = 0; i < N; i++) {
            var c = txt.charAt(i);

            if(!Character.isDigit(c)) { return txt.substring(0, i); }
        }

        return txt;
    }
}
