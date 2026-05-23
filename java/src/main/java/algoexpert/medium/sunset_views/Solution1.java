package algoexpert.medium.sunset_views;
import java.util.*;

// Approach: Single pass from horizon side, track running max.
class Solution1 {
    public ArrayList<Integer> sunsetViews(int[] B, String direction) {
        var maxIdx = -1;
        var N = B.length;
        var R = new ArrayList<Integer>();

        if(direction.equals("EAST")) {
            for(var idx = N - 1; 0 <= idx; idx--) {
                if(maxIdx != -1 && B[idx] <= B[maxIdx]) { continue; }

                maxIdx = idx;
                R.add(0, maxIdx);
            }
        }
        else {
            for(var idx = 0; idx < N; idx++) {
                if(maxIdx != -1 && B[idx] <= B[maxIdx]) { continue; }

                maxIdx = idx;
                R.add(maxIdx);
            }
        }

        return R;
    }
}
