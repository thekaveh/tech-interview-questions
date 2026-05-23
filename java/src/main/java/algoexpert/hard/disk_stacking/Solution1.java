package algoexpert.hard.disk_stacking;
import java.util.*;

// Approach: Sort by height + LIS-style DP with path reconstruction.
class Solution1 {
    public static List<Integer[]> diskStacking(List<Integer[]> disks) {
        var N = disks.size();

        var H = new int[N];
        var SEQ = new int[N];

        disks.sort((v, w) -> v[2] - w[2]);

        var max = 0;

        for (var hi = 0; hi < N; hi++) {
            var hiDisk = disks.get(hi);

            H[hi] = hiDisk[2];
            SEQ[hi] = Integer.MIN_VALUE;

            for (var lo = 0; lo < hi; lo++) {
                var loDisk = disks.get(lo);

                if (loDisk[0] >= hiDisk[0] || loDisk[1] >= hiDisk[1] || loDisk[2] >= hiDisk[2]) {
                    continue;
                }
                if (H[lo] + hiDisk[2] <= H[hi]) {
                    continue;
                }

                H[hi] = H[lo] + hiDisk[2];
                SEQ[hi] = lo;
            }

            if (H[max] < H[hi]) {
                max = hi;
            }
        }

        var R = new ArrayList<Integer[]>();
        for (var at = max; at != Integer.MIN_VALUE; at = SEQ[at]) {
            R.add(0, disks.get(at));
        }
        return R;
    }
}
