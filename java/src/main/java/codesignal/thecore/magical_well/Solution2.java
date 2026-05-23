package codesignal.thecore.magical_well;
import java.util.stream.IntStream;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: IntStream.range mapping each draw index to its product, then summing.
class Solution2 {
    static int solution(int a, int b, int n) {
        return IntStream.range(0, n)
                        .map(i -> (a + i) * (b + i))
                        .sum();
    }
}
