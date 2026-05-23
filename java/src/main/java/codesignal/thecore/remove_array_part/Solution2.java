package codesignal.thecore.remove_array_part;
import java.util.stream.IntStream;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: IntStream filter keeping only indices outside [lo, hi].
class Solution2 {
    static int[] solution(int[] A, int lo, int hi) {
        var N = A.length;

        return IntStream.range(0, N)
                        .filter(idx -> idx < lo || idx > hi)
                        .map(idx -> A[idx])
                        .toArray();
    }
}
