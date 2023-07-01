import java.util.*;

class Solution2 {
    public static List<List<Integer>> powerset(List<Integer> A) {
        var Q = new LinkedList<List<Integer>>();

        Q.offer(new ArrayList<>());

        for(var a : A) {
            var L = Q.size();

            for(var i = 0; i < L; i++) {
                var T = Q.poll();

                var U = new ArrayList<>(T);
                U.add(a);

                Q.offer(T);
                Q.offer(U);
            }
        }

        return new ArrayList<>(Q);
    }
}