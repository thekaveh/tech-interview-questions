package algoexpert.medium.smallest_difference;
import java.util.*;

// Approach: Sort both, two-pointer with tracked best indices.
class Solution3 {
    public static int[] smallestDifference(int[] A, int[] B) {
        var M = A.length;
        var N = B.length;

        Arrays.sort(A);
        Arrays.sort(B);

        var idxA = 0;
        var idxB = 0;

        for(int i = 0, j = 0; i < M && j < N;) {
            var a = A[i];
            var b = B[j];

            if(Math.abs(a - b) < Math.abs(A[idxA] - B[idxB])) { idxA = i; idxB = j; }

            if      (a < b) { i++; }
            else if (b < a) { j++; }
            else            { break; }
        }

        return new int[] { A[idxA], B[idxB] };
    }
}
