package algoexpert.medium.staircase_traversal;
import java.util.*;

// Approach: Bottom-up DP table.
class Solution3 {
    // T: O(H * S) - S: O(H)
    public int staircaseTraversal(int H, int S) {
        var M = new int[H + 1];

        M[0] = M[1] = 1;
        
        for(var h = 2; h <= H; h++) {
            for(var s = 1; s <= Math.min(h, S); s++) {
                M[h] += M[h - s];
            }
        }

        return M[H];
    }
}
