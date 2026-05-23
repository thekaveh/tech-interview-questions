package algoexpert.medium.merge_overlapping_intervals;
import java.util.*;

// Approach: MinPQ sort + pairwise merge with re-offer.
class Solution1 {
    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        var N = intervals.length;

        if(N == 0 || N == 1) { return intervals; }

        var R = new LinkedList<int[]>();
        var minPQ = new PriorityQueue<int[]>((intA, intB) -> intA[0] - intB[0]);

        for(var interval : intervals) { minPQ.offer(interval); }

        while(minPQ.size() >= 2) {
            var a = minPQ.poll();
            var b = minPQ.peek();

            if(a[1] < b[0]) { R.add(a); }
            else            { minPQ.poll(); minPQ.offer(new int[] { a[0], Math.max(a[1], b[1]) }); }
        }

        R.add(minPQ.poll());

        return R.toArray(new int[0][]);
    }
}
