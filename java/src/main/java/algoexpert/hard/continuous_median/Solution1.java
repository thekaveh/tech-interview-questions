package algoexpert.hard.continuous_median;
import java.util.*;

// Approach: TODO.
// Do not edit the class below except for
// the insert method. Feel free to add new
// properties and methods to the class.
class Solution1 {
    static class ContinuousMedianHandler {
        double median = 0;

        PriorityQueue<Integer> minPQ = new PriorityQueue<>((a, b) -> a - b);
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b - a);

        public void insert(int number) {
            if(maxPQ.size() == 0 || number <= maxPQ.peek()) { maxPQ.offer(number); }
            else                                            { minPQ.offer(number); }

            if      (maxPQ.size() > minPQ.size() + 1)   { minPQ.offer(maxPQ.poll()); }
            else if (minPQ.size() > maxPQ.size())       { maxPQ.offer(minPQ.poll()); }

            this.median = (minPQ.size() == maxPQ.size())
                ? (minPQ.peek() + maxPQ.peek()) / 2.0
                : maxPQ.peek();
        }

        public double getMedian() { return median; }
    }
}
