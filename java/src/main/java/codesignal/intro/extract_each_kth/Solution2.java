package codesignal.intro.extract_each_kth;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution2 {
    static int[] solution(int[] A, int k) {
        var N = A.length;

        return IntStream.range(0, N)
                        .filter(i -> (i + 1) % k != 0)
                        .map(i -> A[i])
                        .toArray();
    }
}
