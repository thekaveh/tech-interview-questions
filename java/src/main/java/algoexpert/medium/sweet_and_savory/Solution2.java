package algoexpert.medium.sweet_and_savory;
import java.util.*;

// Approach: Sort + two-pointer from both ends toward target.
class Solution2 {
    public int[] sweetAndSavory(int[] dishes, int target) {
        var N = dishes.length;
        var nil = new int[] { 0, 0 };

        if (N < 2) { return nil; }

        Arrays.sort(dishes);

        var savoryLo = 0; while (dishes[savoryLo] < 0) { savoryLo++; }

        if (savoryLo == 0) { return nil; }

        var ret = new int[2];
        var bestDif = Integer.MAX_VALUE;

        for (int sweetIdx = savoryLo - 1, savoryIdx = savoryLo; 0 <= sweetIdx && savoryIdx < N;) {
            var profile = dishes[sweetIdx] + dishes[savoryIdx];

            if (target < profile) { sweetIdx--; }
            else {
                var dif = target - profile;

                if (dif < bestDif) {
                    bestDif = dif;

                    ret[0] = dishes[sweetIdx];
                    ret[1] = dishes[savoryIdx];
                }

                savoryIdx++;
            }
        }

        return ret;
    }
}
