import java.util.*;

class Program {
    public static boolean isMonotonic(int[] A) {
        var N = A.length;
    
        if(N == 0 || N == 1) { return true; }

        var nonInc = true;
        var nonDec = true;

        for(var i = 0; i < N - 1; i++) {
            if(A[i] < A[i + 1]) { nonInc = false; }
            if(A[i] > A[i + 1]) { nonDec = false; }
        }

        return nonInc || nonDec;
    }
}