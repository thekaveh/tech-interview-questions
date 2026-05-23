package codesignal.thecore.addition_without_carrying;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Iterative digit-by-digit assembly building result string.
class Solution1 {
    static int solution(int param1, int param2) {
        if(param1 == 0 || param2 == 0) { return param1 + param2; }
        
        var ret = "";
        
        while(param1 > 0 || param2 > 0) {
            var t = 0;
            
            if(param1 > 0) {
                t += param1 % 10;
                
                param1 /= 10;
            }
            
            if(param2 > 0) {
                t += param2 % 10;
                
                param2 /= 10;
            }
            
            ret = (t % 10) + ret;
        }
        
        return Integer.parseInt(ret);
    }
}
