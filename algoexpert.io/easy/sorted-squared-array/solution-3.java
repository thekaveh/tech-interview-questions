import java.util.*;

class Program {

    public int[] sortedSquaredArray(int[] A) {
        var N = A.length;
        var R = new int[N];

        int lo = 0, hi = N - 1;

        for(var k = N - 1; k >= 0; k--) {
            var loSq = A[lo] * A[lo];
            var hiSq = A[hi] * A[hi];

            if(loSq >= hiSq)  { R[k] = loSq; lo++; }
            else              { R[k] = hiSq; hi--; }
        }

        return R;
    }
}