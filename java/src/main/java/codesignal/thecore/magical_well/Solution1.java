package codesignal.thecore.magical_well;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static int solution(int a, int b, int n) {
        var ret = 0;
        
        while(n > 0) {
            ret += a * b;
            
            a++;
            b++;
            
            n--;
        }
        
        return ret;
    }
}
