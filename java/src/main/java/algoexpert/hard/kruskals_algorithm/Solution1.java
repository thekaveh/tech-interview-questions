package algoexpert.hard.kruskals_algorithm;
import java.util.*;

// Approach: Sort edges + Union-Find (via Map.entry).
class Solution1 {
    static class UF {
        int[] id;

        UF(int N) {
            this.id = new int[N];

            for (var i = 0; i < N; i++) {
                this.id[i] = i;
            }
        }

        int find(int v) {
            while (v != this.id[v]) {
                v = this.id[v];
            }

            return v;
        }

        void union(int v, int w) {
            var vRoot = find(v);
            var wRoot = find(w);

            this.id[vRoot] = wRoot;
        }

        boolean connected(int v, int w) {
            return find(v) == find(w);
        }
    }

    public int[][][] kruskalsAlgorithm(int[][][] E) {
        var M = 0;
        var V = E.length;
        var uf = new UF(V);
        var mst = new ArrayList<ArrayList<int[]>>();
        var minPQ = new PriorityQueue<Map.Entry<Integer, int[]>>((v, w) -> v.getValue()[1] - w.getValue()[1]);

        for (var v = 0; v < V; v++) {
            mst.add(v, new ArrayList<int[]>());

            for (var e : E[v]) {
                minPQ.offer(Map.entry(v, e));
            }
        }

        while (!minPQ.isEmpty() && M < V - 1) {
            var nxt = minPQ.poll();

            var v = nxt.getKey();
            var w = nxt.getValue()[0];
            var vw = nxt.getValue()[1];

            if (uf.connected(v, w)) {
                continue;
            }

            uf.union(v, w);
            mst.get(v).add(new int[] { w, vw });
            mst.get(w).add(new int[] { v, vw });
            M++;
        }

        var R = new int[V][][];

        for (var v = 0; v < V; v++) {
            var W = mst.get(v).size();

            R[v] = new int[W][];

            for (var w = 0; w < W; w++) {
                R[v][w] = mst.get(v).get(w);
            }
        }

        return R;
    }
}
