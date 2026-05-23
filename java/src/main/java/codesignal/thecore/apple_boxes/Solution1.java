package codesignal.thecore.apple_boxes;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static int solution(int k) {
        var ret = 0;
        
        for(var i = 1; i <= k; i++) {
            if(i % 2 == 0)  { ret += i * i; }
            else            { ret -= i * i; }
        }
        
        return ret;
    }   
}
