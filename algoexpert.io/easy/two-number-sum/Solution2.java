import java.util.*;

class Solution2 {
    public static int[] twoNumberSum(int[] A, int S) {
        int N = A.length;
        
        Arrays.sort(A);
        
        for(int i = 0; i < N - 1; i++) {
            int j = Arrays.binarySearch(A, i + 1, N, S - A[i]);
            
            if(j >= 0) {
                return new int[] { A[i], A[j] };
            }
        }
        
        return new int[0];
    }
}