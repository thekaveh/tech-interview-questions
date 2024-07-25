import java.util.*;

class Solution2 {
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

	public int[][][] kruskalsAlgorithm(int[][][] G) {
		var V = G.length;
		var UF = new UF(V);
		var MST = new ArrayList<ArrayList<int[]>>();
		var minPQ = new PriorityQueue<int[]>((v, w) -> v[2] - w[2]);

		for (var v = 0; v < V; v++) {
			MST.add(v, new ArrayList<>());

			for (var e : G[v]) {
				minPQ.offer(new int[] { v, e[0], e[1] });
			}
		}

		var E = 0;
		while (!minPQ.isEmpty() && E < V - 1) {
			var e = minPQ.poll();

			var v = e[0];
			var w = e[1];
			var vw = e[2];

			if (UF.connected(v, w)) {
				continue;
			}

			UF.union(v, w);
			MST.get(v).add(new int[] { w, vw });
			MST.get(w).add(new int[] { v, vw });

			E++;
		}

		var R = new int[V][][];

		for (var v = 0; v < V; v++) {
			R[v] = MST.get(v).toArray(new int[0][]);
		}

		return R;
	}
}