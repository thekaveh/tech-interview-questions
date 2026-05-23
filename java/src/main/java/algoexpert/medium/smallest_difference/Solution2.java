package algoexpert.medium.smallest_difference;
import java.util.*;

// Approach: MaxPQ keeping only the best pair seen.
class Solution2 {
    private static class Tuple {
        private final int a, b;

        public Tuple(int a, int b) { this.a = a; this.b = b; }

        public int dist() { return Math.abs(this.a - this.b); }
    }
    
    public static int[] smallestDifference(int[] A, int[] B) {
        var M = A.length;
        var N = B.length;

        var maxPQ = new PriorityQueue<Tuple>((x, y) -> y.dist() - x.dist());

        for(var i = 0; i < M; i++) {
            for(var j = 0; j < N; j++) {
                maxPQ.offer(new Tuple(A[i], B[j]));

                if(maxPQ.size() > 1) { maxPQ.poll(); }
            }
        }

        var R = maxPQ.poll();

        return new int[] { R.a, R.b };
    }
}
