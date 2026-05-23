package codesignal.thecore.create_array;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Allocate array and fill with Arrays.fill.
class Solution1 {
    static int[] solution(int N) {
        var A = new int[N];
        Arrays.fill(A, 1);
        
        return A;
    }
}
