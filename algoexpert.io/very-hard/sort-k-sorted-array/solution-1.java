import java.util.*;

class Program {

    public int[] sortKSortedArray(int[] A, int k) {
        var N = A.length;
        var minPQ = new PriorityQueue<Integer>((a, b) -> a - b);

        var idx = 0;
        k = Math.min(N, k);

        for(var a : A) {
            minPQ.offer(a);

            if(k < minPQ.size()) { A[idx++] = minPQ.poll(); }
        }

        while(!minPQ.isEmpty()) { A[idx++] = minPQ.poll(); }

        return A;
    }
}