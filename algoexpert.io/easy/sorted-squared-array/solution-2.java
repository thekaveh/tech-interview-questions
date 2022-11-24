import java.util.*;

class Program {

    public int[] sortedSquaredArray(int[] A) {
        var N = A.length;
        var R = new int[N];

        for(int k = N - 1, lo = 0, hi = N - 1; k >= 0 && lo <= hi; k--) {
            var loSq = A[lo] * A[lo];
            var hiSq = A[hi] * A[hi];

            if(hiSq > loSq) { R[k] = hiSq; hi--; }
            else            { R[k] = loSq; lo++; }
        }

        return R;
    }
}