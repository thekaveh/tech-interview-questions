import java.util.*;

class Solution1 {
    public static boolean hasSingleCycle(int[] A) {
        var N = A.length;
        var at = 0;

        for(var jumps = 0; jumps < N; jumps++) {
            if(0 < jumps && at == 0) { return false; }

            at += A[at];
            at = (at % N + N) % N;
        }

        return at == 0;
    }
}