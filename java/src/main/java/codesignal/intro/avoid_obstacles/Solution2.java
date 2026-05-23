package codesignal.intro.avoid_obstacles;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution2 {
    static int solution(int[] A) {
        return IntStream.range(2, Arrays.stream(A).max().getAsInt() + 2)
                        .filter(i -> Arrays.stream(A).allMatch(j -> j % i != 0))
                        .min()
                        .getAsInt();
    }
}
