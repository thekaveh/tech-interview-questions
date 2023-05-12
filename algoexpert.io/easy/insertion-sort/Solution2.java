import java.util.*;

class Solution2 {
    private static final int H = 1;

    public static int[] insertionSort(int[] A) {
        var N = A.length;

        if(N == 0 || N == 1) { return A; }

        for(var hi = H; hi < N; hi++) {
            for(var lo = hi; H <= lo && A[lo - H] > A[lo]; lo -= H) {
                swap(A, lo - H, lo);
            }
        }

        return A;
    }
	
	private static void swap(int[] A, int i, int j) {
		int T = A[i];
		A[i] = A[j];
		A[j] = T;
	}
}