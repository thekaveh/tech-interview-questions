package codesignal.thecore.rounders;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution2 {
    static int solution(int n) {
        var trail = 1;
        
        while(n > 10) {
            trail *= 10;
            n = (n / 10) + (n % 10 < 5 ? 0 : 1);
        }
        
        return n * trail;
    }
}
