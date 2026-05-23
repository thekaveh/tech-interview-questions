package algoexpert.medium.missing_numbers;
import java.util.*;

// Approach: TODO.
class Solution1 {
    // Time: O(n) | Space: O(n)
    public int[] missingNumbers(int[] A) {
        var N = A.length + 2;
        var R = new int[] { -1, -1 };
        var M = new HashSet<Integer>();

        for (var a : A) { M.add(a); }

        for (var a = 1; a <= N; a++) {
            if (!M.contains(a)) {
                if (R[0] == -1) { R[0] = a; }
                else            { R[1] = a; }
            }
        }

        return R;
    }
}
