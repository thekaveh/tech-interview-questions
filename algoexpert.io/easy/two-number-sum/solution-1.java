import java.util.*;

class Program {
    public static int[] twoNumberSum(int[] A, int S) {
        int N = A.length;
        
        for(int i = 0; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                if(A[i] + A[j] == S) {
                    return new int[] { A[i], A[j] };
                }
            }
        }
        
        return new int[0];
    }
}