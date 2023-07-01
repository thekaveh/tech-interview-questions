import java.util.*;

class Solution1 {
    public static List<List<Integer>> getPermutations(List<Integer> A) {
        var N = A.size();

        if(N == 0) { return new ArrayList<>(); }

        var Q = new LinkedList<List<Integer>>();

        Q.offer(new ArrayList<>());

        for(var a : A) {
            var L = Q.size();

            for(var i = 0; i < L; i++) {
                var T = Q.poll();

                for(var j = 0; j <= T.size(); j++) {
                    var U = new ArrayList<>(T);

                    U.add(j, a);

                    Q.offer(U);
                }
            }
        }

        return new ArrayList<>(Q);
    }
}