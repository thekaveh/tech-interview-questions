package algoexpert.easy.find_three_largest_numbers;
import java.util.*;

// Approach: Min-heap of size 3.
class Solution1 {
    public static int[] findThreeLargestNumbers(int[] A) {
        var minPQ = new PriorityQueue<Integer>((a, b) -> a - b);

        for(var a : A) {
            minPQ.offer(a);
            
            if(minPQ.size() > 3) { minPQ.poll(); }
        }

        return new int[] { minPQ.poll() , minPQ.poll() , minPQ.poll() };
    }
}
