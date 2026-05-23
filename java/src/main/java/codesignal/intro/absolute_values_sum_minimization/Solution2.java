package codesignal.intro.absolute_values_sum_minimization;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Direct median index (floor of midpoint).
class Solution2 {
    static int solution(int[] A) {
        var N = A.length;
        
        return A[(N - 1) / 2];
    }
}
