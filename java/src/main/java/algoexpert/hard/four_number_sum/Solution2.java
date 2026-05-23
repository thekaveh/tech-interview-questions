package algoexpert.hard.four_number_sum;
import java.util.*;

// Approach: TODO.
// T: O(N^3) | S: O(1)
class Solution2 {
    public static List<Integer[]> fourNumberSum(int[] A, int S) {
        var N = A.length;
        var R = new ArrayList<Integer[]>();

        Arrays.sort(A);

        for(int i = 0; i < N - 3; i++) {
            for(int j = i + 1; j < N - 2; j++) {
                var lo = j + 1;
                var hi = N - 1;

                while(lo < hi) {
                    var T = A[i] + A[j] + A[lo] + A[hi];

                    if      (T < S) { lo++; }
                    else if (S < T) { hi--; }
                    else            { R.add(new Integer[] { A[i], A[j], A[lo], A[hi] }); lo++; hi--; }
                }
            }
        }
        
        return R;
    }
}
