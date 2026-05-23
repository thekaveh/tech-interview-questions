package algoexpert.hard.underscorify_substring;
import java.util.*;

// Approach: Find all match intervals, merge overlaps, insert underscores.
class Solution1 {
    public static String underscorifySubstring(String text, String substring) {
        var N = text.length();
        var M = substring.length();

        var lo = 0;
        var intervals = new ArrayList<int[]>();

        while (lo < N) {
            var hi = text.indexOf(substring, lo);

            if (hi != -1) {
                intervals.add(new int[] { hi, hi + M });
                lo = hi + 1;
            } else {
                break;
            }
        }

        if (intervals.size() == 0) {
            return text;
        }

        var minPQ = new PriorityQueue<int[]>((v, w) -> v[0] - w[0]);
        for (var interval : intervals) {
            minPQ.offer(interval);
        }
        intervals.clear();

        while (1 < minPQ.size()) {
            var v = minPQ.poll();
            var w = minPQ.peek();

            if (w[0] <= v[1]) {
                minPQ.poll();
                minPQ.offer(new int[] { v[0], Math.max(v[1], w[1]) });
            } else {
                intervals.add(v);
            }
        }
        intervals.add(minPQ.poll());

        var delta = 0;
        var R = new StringBuilder(text);
        for (var interval : intervals) {
            R.insert(interval[0] + (delta++), "_");
            R.insert(interval[1] + (delta++), "_");
        }

        return R.toString();
    }
}
