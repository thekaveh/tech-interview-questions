package algoexpert.medium.single_cycle_check;
import java.util.*;

// Approach: Recursive jump simulation with jump counter.
class Solution2 {
    public static boolean hasSingleCycle(int[] A) {
        return hasSingleCycle(A, 0, 0);
    }

    private static boolean hasSingleCycle(int[] A, int at, int jumps) {
        var N = A.length;
        
        at = (at % N + N) % N;

        if(jumps == N) { return at == 0; }
        if(0 < jumps && jumps < N && at == 0) { return false; }

        return hasSingleCycle(A, at + A[at], jumps + 1);
    }
}
