package codesignal.thecore.add_two_digits;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Iterative digit extraction via modulo loop.
class Solution1 {
    static int solution(int n) {
        var S = 0;
        
        while(n > 0) {
            S += n % 10;
            
            n /= 10;
        }
        
        return S;
    }
}
