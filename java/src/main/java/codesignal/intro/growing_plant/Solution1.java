package codesignal.intro.growing_plant;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static int solution(int upSpeed, int downSpeed, int desiredHeight) {
        var days = 0;
        var height = 0;
        
        while(true) {
            days++;
            
            height += upSpeed;
            
            if(height >= desiredHeight) { break; }
            
            height -= downSpeed;
        }
        
        return days;
    }
}
