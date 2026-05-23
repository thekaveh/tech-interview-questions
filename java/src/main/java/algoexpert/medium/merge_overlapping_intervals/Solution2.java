package algoexpert.medium.merge_overlapping_intervals;
import java.util.*;

// Approach: MinPQ sort + extend last result interval in place.
class Solution2 {
    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        var N = intervals.length;
        
        if(N == 0 || N == 1) { return intervals; }
        
        var R = new ArrayList<int[]>();
        var minPQ = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        
        for(var interval : intervals) { minPQ.offer(interval); }
        
        R.add(minPQ.poll());
        
        while(!minPQ.isEmpty()) {
            var L = R.size();
            var top = R.get(L - 1);
            var next = minPQ.poll();
                
            if(top[1] < next[0])    { R.add(next); }
            else 					{ top[1] = Math.max(top[1], next[1]); } 
        }
        
        return R.toArray(new int[R.size()][]);
    }
}
