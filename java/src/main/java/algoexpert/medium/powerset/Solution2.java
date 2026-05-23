package algoexpert.medium.powerset;
import java.util.*;

// Approach: TODO.
class Solution2 {
    public static List<List<Integer>> powerset(List<Integer> A) {
        var Q = new LinkedList<List<Integer>>();

        Q.offer(new ArrayList<>());

        for(var a : A) {
            var L = Q.size();

            for(var i = 0; i < L; i++) {
                var V = Q.poll();

                var W = new ArrayList<>(V);
                W.add(a);

                Q.offer(V);
                Q.offer(W);
            }
        }

        return new ArrayList<>(Q);
    }
}
