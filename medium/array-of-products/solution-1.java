import java.util.*;

class Program {
    public int[] arrayOfProducts(int[] A) {
        var N = A.length;
        var R = new int[N];
        
        for(int i = 0, p = 1; i < N; i++)       { R[i] = p; p *= A[i]; }
        for(int i = N - 1, p = 1; i >= 0; i--)  { R[i] *= p; p *= A[i]; }

        return R;
    }
}