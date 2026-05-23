package codesignal.thecore.make_array_consecutive_2;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution2 {
    static int solution(int[] A) {
        var N = A.length;

        Arrays.sort(A);

        return A[N - 1] - A[0] + 1 - N;
    }
}
