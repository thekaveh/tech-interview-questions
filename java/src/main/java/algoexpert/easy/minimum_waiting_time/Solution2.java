package algoexpert.easy.minimum_waiting_time;
import java.util.*;

// Approach: Sort, multiply each by remaining count.
class Solution2 {
    public int minimumWaitingTime(int[] Q) {
        var R = 0;
        var N = Q.length;

        Arrays.sort(Q);

        for(var i = 0; i < N; i++) { R +=  (N - i - 1) * Q[i]; }

        return R;
    }
}
