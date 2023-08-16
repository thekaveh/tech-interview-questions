import java.util.*;

class Solution1 {
    static class Idx2D {
        int x, y;
        public Idx2D(int x, int y) { this.x = x; this.y = y;  }

        public int[] toArray() { return new int[] { this.x, this.y }; }
        public int heuristic(Idx2D that) { return Math.abs(that.x - this.x) + Math.abs(that.y - this.y); }
        public int priority(Idx2D that, Map<Idx2D, Integer> D) { return D.get(this) + this.heuristic(that); }

        @Override public int hashCode() { return Integer.hashCode(this.x) + 31 * Integer.hashCode(this.y); }

        @Override public boolean equals(Object o) { var that = (Idx2D) o; return this.x == that.x && this.y == that.y; }

        public Idx2D[] adj() {
            return new Idx2D[] {
                new Idx2D(this.x - 1, this.y)
                , new Idx2D(this.x, this.y - 1)
                , new Idx2D(this.x + 1, this.y)
                , new Idx2D(this.x, this.y + 1)
            };
        }

        public boolean isValid(int[][] G) {
            var R = G.length;
            var C = G[0].length;

            if (this.x < 0 || R <= this.x)  { return false; }
            if (this.y < 0 || C <= this.y)  { return false; }
            if (G[this.x][this.y] == 1)     { return false; }

            return true;
        }
    }

    public int[][] aStarAlgorithm(int srcX, int srcY, int dstX, int dstY, int[][] G) {
        var R = G.length;
        var C = G[0].length;

        var nil = new Idx2D(-1, -1);
        var src = new Idx2D(srcX, srcY);
        var dst = new Idx2D(dstX, dstY);

        var P = new HashMap<Idx2D, Idx2D>();
        var D = new HashMap<Idx2D, Integer>();
        var PQ = new PriorityQueue<Idx2D>((v, w) -> v.priority(dst, D) - w.priority(dst, D));

        for (var r = 0; r < R; r++) {
            for (var c = 0; c < C; c++) {
                var v = new Idx2D(r, c);

                P.put(v, nil);
                D.put(v, Integer.MAX_VALUE);
            }
        }

        D.put(src, 0);
        PQ.offer(src);

        while (!PQ.isEmpty()) {
            var v = PQ.poll();

            if (v.equals(dst)) { break; }

            for (var w : v.adj()) {
                if (!w.isValid(G)) { continue; }

                if (D.get(v) + 1 < D.get(w)) {
                    P.put(w, v);
                    PQ.offer(w);
                    D.put(w, D.get(v) + 1);
                }
            }
        }

        var T = new ArrayList<int[]>();
        for (var v = dst; !v.equals(nil); v = P.get(v)) { T.add(0, v.toArray()); }

        if (!Arrays.equals(T.get(0), src.toArray())) { return new int[0][2]; }

        return T.toArray(new int[T.size()][2]);
    }
}