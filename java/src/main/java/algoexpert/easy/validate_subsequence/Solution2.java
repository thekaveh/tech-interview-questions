package algoexpert.easy.validate_subsequence;
import java.util.*;

// Approach: Single pass, dual index for-loop.
class Solution2 {
    public static boolean isValidSubsequence(List<Integer> A, List<Integer> B) {
        int i = 0, M = A.size();
        int j = 0, N = B.size();

        for(; i < M && j < N; i++) {
            if(A.get(i) == B.get(j)) { j++; }
        }

        return j == N;
    }
}
