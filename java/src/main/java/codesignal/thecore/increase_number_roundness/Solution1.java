package codesignal.thecore.increase_number_roundness;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static boolean solution(int n) {
        var str = Integer.toString(n);
        var N = str.length();
        
        var lo = 0;
        var hi = N - 1;
        
        while(lo < hi) {
            if      (str.charAt(hi) == '0') { hi--; }
            else if (str.charAt(lo) != '0') { lo++; }
            else                            { return true; }
        }
        
        return false;
    }
}
