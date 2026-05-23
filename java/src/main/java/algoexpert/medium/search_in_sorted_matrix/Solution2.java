package algoexpert.medium.search_in_sorted_matrix;
import java.util.*;

// Approach: Start top-right, eliminate row or column each step.
class Solution2 {
    public static int[] searchInSortedMatrix(int[][] M, int v) {
        var R = M.length;
        var C = M[0].length;

        var idx = new int[] { 0, C - 1 };

        while(idx[0] < R && 0 <= idx[1]) {
            var t = M[idx[0]][idx[1]];

            if      (t < v) { idx[0]++; }
            else if (v < t) { idx[1]--; }
            else            { return idx; }
        }

        return new int[] { -1, -1 };
    }
}
