package codesignal.intro.extract_each_kth;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Single pass skipping every k-th index.
class Solution1 {
    static int[] solution(int[] A, int k) {
        var M = A.length;
        var N = M - M / k;
        
        var B = new int[N];

        var j = 0;
        for(var i = 0; i < M; i++) {
            if((i + 1) % k == 0) { continue; }
            
            B[j++] = A[i];        
        }
        
        return B;
    }
}
