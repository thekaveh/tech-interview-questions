package algoexpert.medium.permutations;
import java.util.*;

// Approach: TODO.
class Solution3 {
    public static List<List<Integer>> getPermutations(List<Integer> A) {
        var R = new ArrayList<List<Integer>>();

        solve(A, 0, R);

        return R;
    }

    private static void solve(List<Integer> A, int at, List<List<Integer>> R) {
        var N = A.size();

        if(at == N - 1) {
            R.add(new ArrayList<>(A));

            return;
        }

        for(var i = at; i < N; i++) {
            swap(A, at, i);

            solve(A, at + 1, R);

            swap(A, at, i);
        }
    }
    
    private static void swap(List<Integer> A, int i, int j) {
        var T = A.get(i);
        A.set(i, A.get(j));
        A.set(j, T);
	}
}
