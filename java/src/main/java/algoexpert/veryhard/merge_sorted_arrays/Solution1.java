package algoexpert.veryhard.merge_sorted_arrays;
import java.util.*;

// Approach: TODO.
class Solution1 {
    private static class Idx2D {
        int r, c;

        public Idx2D(int i, int j) { this.r = i; this.c = j; }
    }

    public static List<Integer> mergeSortedArrays(List<List<Integer>> M) {
        var R = new ArrayList<Integer>();
        var minPQ = new PriorityQueue<Idx2D>((idxA, idxB) -> M.get(idxA.r).get(idxA.c) - M.get(idxB.r).get(idxB.c));

        for (var r = 0; r < M.size(); r++) { minPQ.offer(new Idx2D(r, 0)); }

        while (!minPQ.isEmpty()) {
            var v = minPQ.poll();

            R.add(M.get(v.r).get(v.c));

            if (v.c + 1 < M.get(v.r).size()) { minPQ.offer(new Idx2D(v.r, v.c + 1)); }
        }

        return R;
    }
}
