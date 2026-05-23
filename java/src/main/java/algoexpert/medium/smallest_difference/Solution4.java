package algoexpert.medium.smallest_difference;
import java.util.*;

// Approach: Sort both, two-pointer with tracked best pair values.
class Solution4 {
    public static int[] smallestDifference(int[] A, int[] B) {
        var M = A.length;
        var N = B.length;

        Arrays.sort(A);
        Arrays.sort(B);

        var R = new int[] { A[0], B[0] };

        for(int idxA = 0, idxB = 0; idxA < M && idxB < N;) {
            var a = A[idxA];
            var b = B[idxB];

            if(Math.abs(a - b) < Math.abs(R[0] - R[1])) { R[0] = A[idxA]; R[1] = B[idxB]; }

            if      (a < b) { idxA++; }
            else if (b < a) { idxB++; }
            else            { break; }
        }

        return R;
    }
}
