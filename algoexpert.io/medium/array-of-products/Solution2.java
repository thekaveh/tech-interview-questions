import java.util.*;

class Solution2 {
    public int[] arrayOfProducts(int[] A) {
        var N = A.length;
        var R = new int[N];

        Arrays.fill(R, 1);

        for(int i = 0, p = 1; i < N; i++)       { R[i] *= p; p *= A[i]; }
        for(int i = N - 1, p = 1; 0 <= i; i--)  { R[i] *= p; p *= A[i]; }

        return R;
    }
}