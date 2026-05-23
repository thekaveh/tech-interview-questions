package algoexpert.easy.sorted_squared_array;
import java.util.*;

// Approach: TODO.
class Solution2 {
    public int[] sortedSquaredArray(int[] A) {
        var N = A.length;
        var R = new int[N];

        for(int k = N - 1, lo = 0, hi = N - 1; 0 <= k && lo <= hi; k--) {
            var loSq = A[lo] * A[lo];
            var hiSq = A[hi] * A[hi];

            if(loSq < hiSq) { R[k] = hiSq; hi--; }
            else            { R[k] = loSq; lo++; }
        }

        return R;
    }
}
