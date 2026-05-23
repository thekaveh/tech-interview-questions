package algoexpert.medium.permutations;
import java.util.*;

// Approach: Iterative insertion into each position of growing permutations.
class Solution1 {
    public static List<List<Integer>> getPermutations(List<Integer> A) {
        var N = A.size();

        if(N == 0) { return new ArrayList<>(); }

        var Q = new LinkedList<List<Integer>>();

        Q.offer(new ArrayList<>());

        for(var a : A) {
            var L = Q.size();

            for(var i = 0; i < L; i++) {
                var V = Q.poll();

                for(var j = 0; j <= V.size(); j++) {
                    var W = new ArrayList<>(V);

                    W.add(j, a);

                    Q.offer(W);
                }
            }
        }

        return new ArrayList<>(Q);
    }
}
