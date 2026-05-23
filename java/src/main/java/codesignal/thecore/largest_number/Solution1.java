package codesignal.thecore.largest_number;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Build the result by appending a 9 for each digit position in a loop.
class Solution1 {
    static int solution(int n) {
        var R = 0;
        
        while(n > 0) {
            R = R * 10 + 9;
            
            n--;
        }
        
        return R;
    }
}
