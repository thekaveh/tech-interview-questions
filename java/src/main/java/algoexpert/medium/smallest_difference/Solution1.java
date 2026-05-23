package algoexpert.medium.smallest_difference;
import java.util.*;

// Approach: TODO.
class Solution1 {
    private static class Index {
        private final int a, b;

        public Index(int a, int b) { this.a = a; this.b = b; }
    }
    
    public static int[] smallestDifference(int[] A, int[] B) {
        var M = A.length;
        var N = B.length;

        var minPQ = new PriorityQueue<Index>((indX, indY) -> Math.abs(A[indX.a] - B[indX.b]) - Math.abs(A[indY.a] - B[indY.b]));

        for(var i = 0; i < M; i++) {
            for(var j = 0; j < N; j++) {
                minPQ.offer(new Index(i, j));
            }
        }

        var R = minPQ.poll();

        return new int[] { A[R.a], B[R.b] };
    }
}
