package algoexpert.medium.search_in_sorted_matrix;
import java.util.*;

// Approach: Row-by-row linear scan with early break.
class Solution1 {
    public static int[] searchInSortedMatrix(int[][] M, int v) {
        var R = M.length;
        var C = M[0].length;

        for(var r = R - 1; 0 <= r; r--) {
            for(var c = 0; c < C; c++) {
                var cmp = Integer.valueOf(M[r][c]).compareTo(v);

                if      (cmp < 0) { continue; }
                else if (0 < cmp) { break;  }
                else              { return new int[] { r, c }; }
            }
        }

        return new int[] { -1, -1 };
    }
}
