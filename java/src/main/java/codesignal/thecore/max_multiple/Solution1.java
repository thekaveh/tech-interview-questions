package codesignal.thecore.max_multiple;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static int solution(int divisor, int bound) {
        for(var n = bound; n > 0; n--) {
            if(n % divisor == 0) { return n; }
        }
        
        return -1;
    }
}
