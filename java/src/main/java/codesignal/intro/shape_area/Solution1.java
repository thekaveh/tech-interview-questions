package codesignal.intro.shape_area;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Recursive summation of 4*(n-1) per layer.
class Solution1 {
    static int solution(int n) {
        if(n == 1) { return 1; }
        
        return solution(n - 1) + 4 * (n - 1);
    }
}
