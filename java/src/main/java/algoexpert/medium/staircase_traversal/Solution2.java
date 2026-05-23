package algoexpert.medium.staircase_traversal;
import java.util.*;

// Approach: Top-down recursion with memoization.
class Solution2 {
    // T: O(H * S) - S: O(H)
    public int staircaseTraversal(int H, int S) {
        return solve(H, S, new Integer[H + 1]);
    }

    private static int solve(int H, int S, Integer[] M) {
        if(H <= 1)          { return 1; }
        if(M[H] != null)    { return M[H]; }

        M[H] = 0;
        
        for(var s = 1; s <= Math.min(S, H); s++) {
            M[H] += solve(H - s, S, M);
        }

        return M[H];
    }
}
