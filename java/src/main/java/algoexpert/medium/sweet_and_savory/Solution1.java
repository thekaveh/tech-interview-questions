package algoexpert.medium.sweet_and_savory;
import java.util.*;

// Approach: Sort + brute-force all pairs with min-PQ for best.
class Solution1 {

    public int[] sweetAndSavory(int[] dishes, int target) {
        var N = dishes.length;
        var nil = new int[] { 0, 0 };

        if (N < 2) { return nil; }

        var PQ = new PriorityQueue<int[]>((v, w) -> target - v[0] - v[1] - (target - w[0] - w[1]));

        Arrays.sort(dishes);

        var savoryLo = 0; while (dishes[savoryLo] < 0) { savoryLo++; }

        if (savoryLo == 0) { return nil; }

        for (var sweetIdx = 0; sweetIdx < savoryLo; sweetIdx++) {
            for (var savoryIdx = savoryLo; savoryIdx < N; savoryIdx++) {
                var profile = dishes[sweetIdx] + dishes[savoryIdx];

                if (target < profile) { continue; }

                PQ.offer(new int[] { dishes[sweetIdx], dishes[savoryIdx] });
            }
        }

        return (PQ.size() == 0) ? nil : PQ.poll();
    }
}
