import java.util.*;

class Solution1 {
    public static List<Integer> zigzagTraverse(List<List<Integer>> A) {
        var R = A.size();
        var C = A.get(0).size();

        var M = new boolean[R][C];
        var Q = new LinkedList<int[]>();
        var Z = new ArrayList<Integer>();

        var order = true;
        var s = new int[] { 0, 0 };

        visit(s, A, M, Q);

        while (!Q.isEmpty()) {
            var L = new ArrayList<Integer>();

            for (var i = Q.size(); 0 < i; i--) {
                var v = Q.poll();
                var a = A.get(v[0]).get(v[1]);

                if (order)  { L.add(a); }
                else        { L.add(0, a); }

                for (var w : adj(v)) {
                    if (!canVisit(w, A, M)) { continue; }

                    visit(w, A, M, Q);
                }
            }

            Z.addAll(L);
            order = !order;
        }

        return Z;
    }

    private static int[][] adj(int[] v) {
        var r = v[0];
        var c = v[1];

        return new int[][] {
                new int[]   { r, c + 1 }
                , new int[] { r + 1, c }
        };
    }

    private static boolean canVisit(int[] v, List<List<Integer>> A, boolean[][] M) {
        var r = v[0];
        var c = v[1];

        var R = A.size();
        var C = A.get(0).size();

        if (r < 0 || R <= r) { return false; }
        if (c < 0 || C <= c) { return false; }

        if (M[r][c]) { return false; }

        return true;
    }

    private static void visit(int[] v, List<List<Integer>> A, boolean[][] M, Queue<int[]> Q) {
        var r = v[0];
        var c = v[1];

        if (!canVisit(v, A, M)) { return; }

        Q.offer(v);
        M[r][c] = true;
    }
}