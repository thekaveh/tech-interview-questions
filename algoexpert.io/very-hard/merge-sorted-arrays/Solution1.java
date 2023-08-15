import java.util.*;

class Solution1 {
    private static class Idx2D {
        int i, j;

        public Idx2D(int i, int j) { this.i = i; this.j = j; }
    }

    public static List<Integer> mergeSortedArrays(List<List<Integer>> M) {
        var R = new ArrayList<Integer>();
        var minPQ = new PriorityQueue<Idx2D>((idxA, idxB) -> M.get(idxA.i).get(idxA.j) - M.get(idxB.i).get(idxB.j));

        for (var i = 0; i < M.size(); i++) { minPQ.offer(new Idx2D(i, 0)); }

        while (!minPQ.isEmpty()) {
            var v = minPQ.poll();

            R.add(M.get(v.i).get(v.j));

            if (v.j + 1 < M.get(v.i).size()) { minPQ.offer(new Idx2D(v.i, v.j + 1)); }
        }

        return R;
    }
}