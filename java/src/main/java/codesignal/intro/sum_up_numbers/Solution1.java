package codesignal.intro.sum_up_numbers;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static int solution(String txt) {
        var sum = 0;
        var N = txt.length();

        for(var lo = 0; lo < N; lo++) {
            while(lo < N && !Character.isDigit(txt.charAt(lo))) { lo++; }

            var hi = lo;
            while(hi < N && Character.isDigit(txt.charAt(hi))) { hi++; }
            
            sum += (lo < N) ? Integer.parseInt(txt.substring(lo, hi)) : 0;

            lo = hi;
        }

        return sum;
    }
}
