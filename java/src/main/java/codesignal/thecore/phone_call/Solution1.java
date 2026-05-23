package codesignal.thecore.phone_call;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static int solution(int min1, int min2_10, int min11, int s) {
        var t = 0;
        
        while(true) {
            if      (t < 1 && min1 <= s)                { s -= min1; t++; }
            else if (1 <= t && t <= 9 && min2_10 <= s)  { s -= min2_10; t++; }
            else if (10 <= t && min11 <= s)             { s -= min11; t++; }
            else                                        { break; }
        }
        
        return t;
    }
}
