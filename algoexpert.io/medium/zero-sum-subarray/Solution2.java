import java.util.*;

class Solution2 {
    public boolean zeroSumSubarray(int[] A) {
        var M = new HashSet<Integer>();

        M.add(0);
        var S = 0;

        for (var a : A) {
            S += a;

            if (M.contains(S)) { return true; }

            M.add(S);
        }

        return false;
    }
}