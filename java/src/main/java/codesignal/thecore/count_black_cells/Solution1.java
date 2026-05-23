package codesignal.thecore.count_black_cells;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static int solution(int n, int m) {
        return n + m + gcd(n, m) - 2;
    }
    
    static int gcd(int a, int b) {
        if(b == 0) { return a; }
        
        return gcd(b, a % b);
    }
}
