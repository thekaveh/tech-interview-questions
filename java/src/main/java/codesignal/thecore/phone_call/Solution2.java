package codesignal.thecore.phone_call;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution2 {
    static int solution(int min1, int min2_10, int min11, int s) {
        var t1 = min1 + min2_10 * 9;

        if(s >= t1) {
            return 10 + (s - t1) / min11;
        }

        if(s >= min1) {
            return (s - min1) / min2_10 + 1;
        }
        
        return 0;
    }
}
