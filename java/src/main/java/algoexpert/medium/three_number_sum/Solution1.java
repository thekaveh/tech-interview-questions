package algoexpert.medium.three_number_sum;
import java.util.*;

// Approach: Sort + brute force triple nested loop.
class Solution1 {
    public static List<Integer[]> threeNumberSum(int[] A, int S) {
        var N = A.length;
        var R = new ArrayList<Integer[]>();
            
        Arrays.sort(A);

        for(int i = 0; i < N - 2; i++) {
            for(int j = i + 1; j < N - 1; j++) {
                for(int k = j + 1; k < N; k++) {
                    if(A[i] + A[j] + A[k] == S) {
                        R.add(new Integer[] { A[i], A[j], A[k] });
                    }
                }
            }
        }

        return R;
    }
}
