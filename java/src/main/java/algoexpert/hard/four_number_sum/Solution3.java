package algoexpert.hard.four_number_sum;
import java.util.*;

// Approach: Hash map of pair sums.
class Solution3 {
    public static List<Integer[]> fourNumberSum(int[] A, int S) {
        var N = A.length;

        var R = new ArrayList<Integer[]>();
        var M = new HashMap<Integer, List<Integer[]>>();

        for (var mid = 1; mid < N - 1; mid++) {
            for (var hi = mid + 1; hi < N; hi++) {
                var delta = S - A[mid] - A[hi];

                if (M.containsKey(delta)) {
                    for (var pair : M.get(delta)) {
                        R.add(new Integer[] { pair[0], pair[1], A[mid], A[hi] });
                    }
                }
            }

            for (var lo = 0; lo < mid; lo++) {
                var s = A[mid] + A[lo];

                M.putIfAbsent(s, new ArrayList<>());
                M.get(s).add(new Integer[] { A[lo], A[mid] });
            }
        }

        return R;
    }
}
