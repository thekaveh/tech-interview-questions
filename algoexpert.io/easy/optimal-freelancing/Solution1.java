import java.util.*;

class Solution1 {
    public int optimalFreelancing(Map<String, Integer>[] jobs) {
        var N = 7;
        var R = new int[N];
        var PQ = new PriorityQueue<Map<String, Integer>>((a, b) -> b.get("payment") - a.get("payment"));

        for (var job : jobs) { PQ.offer(job); }

        while (!PQ.isEmpty()) {
            var v = PQ.poll();

            for (var idx = Math.min(v.get("deadline"), N) - 1; 0 <= idx; idx--) {
                if (R[idx] != 0) { continue; }

                R[idx] = v.get("payment");
                break;
            }
        }

        return Arrays.stream(R).sum();
    }
}