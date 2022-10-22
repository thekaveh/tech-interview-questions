import java.util.*;

class Program {
    private static class Index {
        private final int i, j;
      
        public Index(int i, int j) { this.i = i; this.j = j; }
    }
    
    public static int[] smallestDifference(int[] A, int[] B) {
        var M = A.length;
        var N = B.length;

        var minPQ = new PriorityQueue<Index>((indX, indY) -> Math.abs(A[indX.i] - B[indX.j]) - Math.abs(A[indY.i] - B[indY.j]));

        for(var i = 0; i < M; i++) {
            for(var j = 0; j < N; j++) {
                minPQ.offer(new Index(i, j));
            }
        }

        var R = minPQ.poll();

        return new int[] { A[R.i], B[R.j] };
    }
}