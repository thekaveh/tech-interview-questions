import java.util.*;

class Program {
    static class UF {
        private int[] id;

        public UF(int N) {
            this.id = new int[N];

            for(var i = 0; i < N; i++) { this.id[i] = i; }
        }

        public int find(int v) {
            while(v != this.id[v]) { v = this.id[v]; }
            
            return v;
        }

        public void union(int v, int w) {
            var vId = find(v);
            var wId = find(w);

            this.id[vId] = wId;
        }

        public boolean connected(int v, int w) {
            return find(v) == find(w);
        }
    }

    public int[][][] kruskalsAlgorithm(int[][][] E) {
        var M = 0;
        var N = E.length;
        var uf = new UF(N);
        var mst = new ArrayList<ArrayList<int[]>>();
        var minPQ = new PriorityQueue<Map.Entry<Integer, int[]>>((p, q) -> p.getValue()[1] - q.getValue()[1]);

        for(var v = 0; v < N; v++) {
            for(var e : E[v]) { minPQ.offer(Map.entry(v, e)); }

            mst.add(v, new ArrayList<int[]>());
        }

        while(!minPQ.isEmpty() && M < N - 1) {
            var e = minPQ.poll();

            var v = e.getKey();
            var w = e.getValue()[0];
            var weight = e.getValue()[1];

            if(uf.connected(v, w)) { continue; }

            uf.union(v, w);
            
            M++;
            mst.get(v).add(new int[] { w, weight });
            mst.get(w).add(new int[] { v, weight });
        }

        var R = new int[N][][];
        for(var v = 0; v < N; v++) {
            R[v] = new int[mst.get(v).size()][];

            for(var idx = 0; idx < mst.get(v).size(); idx++) {
                R[v][idx] = mst.get(v).get(idx);
            }
        }

        return R;
    }
}