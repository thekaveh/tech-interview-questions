import java.util.*;

class Program {
    public static int[] findThreeLargestNumbers(int[] A) {
        var minPQ = new PriorityQueue<Integer>((a, b) -> a - b);

        for(var a : A) {
            minPQ.offer(a);
            
            if(minPQ.size() > 3) {  minPQ.poll(); }
        }

        return new int[] { minPQ.poll() , minPQ.poll() , minPQ.poll() };
    }
}