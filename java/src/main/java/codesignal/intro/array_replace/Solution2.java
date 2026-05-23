package codesignal.intro.array_replace;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution2 {
    static int[] solution(int[] A, int from, int to) {
        return Arrays.stream(A)
                     .map(a -> a == from ? to : a)
                     .toArray();
    }
}
