package codesignal.intro.absolute_values_sum_minimization;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Direct median index (ceiling).
class Solution1 {
    static int solution(int[] A) {
        var N = A.length;
        
        return (N % 2 == 0) ? A[N / 2 - 1] : A[N / 2];
    }
}
