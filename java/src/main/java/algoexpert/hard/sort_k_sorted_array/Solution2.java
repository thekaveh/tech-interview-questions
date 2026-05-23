package algoexpert.hard.sort_k_sorted_array;
import java.util.*;

// Approach: Min-heap filling ahead then draining.
class Solution2 {
    public int[] sortKSortedArray(int[] A, int k) {
        var N = A.length;
        var minPQ = new PriorityQueue<Integer>((a, b) -> a - b);

        var at = 0;
        k = Math.min(N, k);

        for(var a : A) {
            minPQ.offer(a);

            if(k < minPQ.size()) { A[at++] = minPQ.poll(); }
        }

        while(!minPQ.isEmpty()) { A[at++] = minPQ.poll(); }

        return A;
    }
}
