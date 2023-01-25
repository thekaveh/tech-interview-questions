import java.util.*;

class Program {
    public static int kadanesAlgorithm(int[] A) {
        var N = A.length;
        var S = Integer.MIN_VALUE;

        for(var lo = 0; lo < N; lo++) {
            for(var hi = lo; hi < N; hi++) {
                var T = 0;

                for(var i = lo; i <= hi; i++) { T += A[i]; }

                if(T > S) { S = T; }
            }
        }

        return S;
    }
}