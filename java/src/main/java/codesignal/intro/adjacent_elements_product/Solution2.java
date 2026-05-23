package codesignal.intro.adjacent_elements_product;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Streams with IntStream.range.
class Solution2 {
    static int solution(int[] A) {
        var N = A.length;

        return IntStream.range(1, N)
                        .map(i -> A[i] * A[i-1])
                        .max()
                        .getAsInt();
    }
}
