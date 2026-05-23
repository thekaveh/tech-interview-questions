package algoexpert.easy.validate_subsequence;
import java.util.*;

// Approach: Single pass, subsequence pointer j.
class Solution1 {
    public static boolean isValidSubsequence(List<Integer> A, List<Integer> S) {
        var M = A.size();
        var N = S.size();

        var j = 0;

        for(var i = 0; i < M && j < N; i++) {
            if(A.get(i) == S.get(j)) { j++; }
        }

        return j == N;
    }
}
