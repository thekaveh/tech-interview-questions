package codesignal.intro.even_digits_only;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static boolean solution(int n) {
        while(n > 0) {
            var d = n % 10;
            
            if(d % 2 == 1) { return false; }
            
            n /= 10;
        }
        
        return true;
    }
}
