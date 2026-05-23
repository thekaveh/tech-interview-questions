package algoexpert.medium.kadanes_algorithm;
import java.util.*;

// Approach: TODO.
class Solution1 {
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
