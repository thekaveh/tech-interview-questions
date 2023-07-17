import java.util.*;

// T: O(N^4) | S: O(1)
class Solution1 {
    public static List<Integer[]> fourNumberSum(int[] A, int S) {
        var N = A.length;
        var R = new ArrayList<Integer[]>();
        
        for(int i = 0; i < N - 3; i++) {
            for(int j = i + 1; j < N - 2; j++) {
                for(int k = j + 1; k < N - 1; k++) {
                    for(int l = k + 1; l < N; l++) {
                        if(A[i] + A[j] + A[k] + A[l] == S) {
                            R.add(new Integer[] { A[i], A[j], A[k], A[l] });
                        }
                    }
                }
            }
        }
        
        return R;
    }
}