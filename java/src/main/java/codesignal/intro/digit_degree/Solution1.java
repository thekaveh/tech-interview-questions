package codesignal.intro.digit_degree;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static int solution(int n) {
        var deg = 0;
        
        while(n >= 10) {
            var t = n;
            var s = 0;
            
            while(t > 0) {
                s += t % 10;
                
                t /= 10;    
            }
            
            n = s;
            deg++;
        }
        
        return deg;
    }
}
