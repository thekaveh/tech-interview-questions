import java.util.*;

class Solution2 {
    public static List<List<Integer>> getPermutations(List<Integer> A) {
        var R = new ArrayList<List<Integer>>();

        solve(A, new ArrayList<Integer>(), R);

        return R;
    }

    private static void solve(List<Integer> A, List<Integer> T, List<List<Integer>> R) {
        if(A.size() == 0 && T.size() > 0) {
            R.add(new ArrayList<Integer>(T));

            return;
        }

        var N = A.size();

        for(var i = 0; i < N; i++) {
            var a = A.get(i);

            A.remove(i);
            T.add(a);

            solve(A, T, R);

            T.remove(T.size() - 1);
            A.add(i, a);
        }
    }
}