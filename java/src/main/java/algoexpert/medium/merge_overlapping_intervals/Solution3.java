package algoexpert.medium.merge_overlapping_intervals;
import java.util.*;

// Approach: TODO.
class Solution3 {
    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        var R = new ArrayList<int[]>();
        var minPQ = new PriorityQueue<int[]>((x, y) -> x[0] - y[0]);

        for(var interval : intervals) { minPQ.offer(interval); }

        while(!minPQ.isEmpty()) {
            var a = minPQ.poll();

            if(minPQ.isEmpty()) { R.add(a); }
            else {
                var b = minPQ.peek();

                if(a[1] < b[0]) { R.add(a); }
                else            { minPQ.poll(); minPQ.offer(new int[] { a[0], Math.max(a[1], b[1]) }); } 
            }
        }

        return R.toArray(new int[0][]);
    }
}
