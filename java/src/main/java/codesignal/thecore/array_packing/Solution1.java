package codesignal.thecore.array_packing;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Shift each element into its byte lane and OR into accumulator.
class Solution1 {
    static int solution(int[] A) {
        var N = A.length;
        var M = 0;

        for(var i = 0; i < N; i++) {
            var a = A[i];

            M += a << (i * 8);
        }

        return M;
    }
}
