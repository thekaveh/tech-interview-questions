package codesignal.thecore.is_power;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static boolean solution(int n) {
        if(n == 1) { return true; }
        
        for(var a = 2; a <= 20; a++){
            for(var b = 2; b <= Math.log(n) / Math.log(a); b++){
                if((int) Math.pow(a, b) == n) {
                    return true;
                }
            }
        }
    
        return false;
    }
}
