import java.util.*;

class Program {

    public int[] sortKSortedArray(int[] A, int k) {
        var i = 0;
        var N = A.length;
        
        k = Math.min(N, k);

        var PQ = new PriorityQueue<Integer>((a, b) -> a - b);
        
        for(; i < N; i++) {
            PQ.offer(A[i]);
            
            if(k < PQ.size()) { A[i - k] = PQ.poll(); }
        }
        
        while(!PQ.isEmpty()) { A[i - k] = PQ.poll(); i++; }
        
        return A;
    }
}