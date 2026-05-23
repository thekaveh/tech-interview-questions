package codesignal.thecore.is_sum_of_consecutive_2;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Nested loop trying all starting values and accumulating prefix sums.
class Solution1 {
    static int solution(int n) {
        int ret = 0;
        
        for(int lo = 1 ; lo < n ; lo++) {
            int sum = 0;
            
            for(int hi = lo ; hi < n ; hi++) {
                sum += hi;
                
                if(sum == n) { ret++; }    
                if(sum >= n) { break; }
            }
        }
        
        return ret;
    }
}
