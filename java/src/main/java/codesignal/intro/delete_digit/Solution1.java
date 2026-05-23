package codesignal.intro.delete_digit;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static int solution(int n) {
        var digits = new StringBuilder();
        
        while(n > 0) {
            digits.insert(0, n % 10);
            
            n /= 10;
        }
        
        var max = 0;
        var N = digits.length();
        
        for(var i = 0; i < N; i++) {
            var T = new StringBuilder(digits);
            
            T.deleteCharAt(i);
            
            max = Math.max(max, Integer.parseInt(T.toString()));
        }
        
        return max;
    }
}
