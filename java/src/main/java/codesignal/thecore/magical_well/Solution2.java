package codesignal.thecore.magical_well;
import java.util.stream.IntStream;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution2 {
    static int solution(int a, int b, int n) {
        return IntStream.range(0, n)
                        .map(i -> (a + i) * (b + i))
                        .sum();
    }
}
