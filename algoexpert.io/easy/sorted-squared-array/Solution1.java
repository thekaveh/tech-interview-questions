import java.util.*;

class Solution1 {
    public int[] sortedSquaredArray(int[] A) {
        var N = A.length;
        var R = new int[N];

        var k = N - 1;

        var lo = 0;
        var hi = N - 1;

        while(lo <= hi) {
            var loSq = A[lo] * A[lo];
            var hiSq = A[hi] * A[hi];

            if(loSq > hiSq) { R[k] = loSq; lo++; }
            else            { R[k] = hiSq; hi--; }

            k--;
        }

        return R;
    }
}