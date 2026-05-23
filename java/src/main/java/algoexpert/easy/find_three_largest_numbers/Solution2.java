package algoexpert.easy.find_three_largest_numbers;
import java.util.*;

// Approach: TODO.
class Solution2 {
    public static int[] findThreeLargestNumbers(int[] A) {
        var maxPQ = new PriorityQueue<Integer>((a, b) -> b - a);

        for(var a : A) { maxPQ.offer(a); }

        var a = maxPQ.poll();
        var b = maxPQ.poll();
        var c = maxPQ.poll();

        return new int[] { c, b, a};
    }
}
