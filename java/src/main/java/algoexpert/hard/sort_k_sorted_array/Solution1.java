package algoexpert.hard.sort_k_sorted_array;
import java.util.*;

// Approach: Min-heap of size k+1, streaming output.
class Solution1 {
    public int[] sortKSortedArray(int[] A, int k) {
        var N = A.length;
        
        k = Math.min(N, k);

        var minPQ = new PriorityQueue<Integer>((a, b) -> a - b);
        
        var at = 0;
        for(; at < N; at++) {
            minPQ.offer(A[at]);
            
            if(k < minPQ.size()) { A[at - k] = minPQ.poll(); }
        }
        
        while(!minPQ.isEmpty()) { A[at - k] = minPQ.poll(); at++; }
        
        return A;
    }
}
