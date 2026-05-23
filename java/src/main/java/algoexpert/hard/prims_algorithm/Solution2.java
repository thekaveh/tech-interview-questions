package algoexpert.hard.prims_algorithm;
import java.util.*;

// Approach: TODO.
class Solution2 {
	public int[][][] primsAlgorithm(int[][][] G) {
		var V = G.length;

		var E = new int[V];
		var W = new int[V];
		var M = new boolean[V];
		var MST = new ArrayList<ArrayList<int[]>>();
		var minPQ = new PriorityQueue<Integer>((v, w) -> W[v] - W[w]);

		for (var v = 0; v < V; v++) {
			E[v] = -1;
			W[v] = Integer.MAX_VALUE;
			MST.add(v, new ArrayList<>());
		}

		W[0] = 0;
		minPQ.offer(0);

		while (!minPQ.isEmpty()) {
			var v = minPQ.poll();
			M[v] = true;

			for (var e : G[v]) {
				var w = e[0];
				var vw = e[1];

				if (M[w]) {
					continue;
				}
				if (W[w] <= vw) {
					continue;
				}

				E[w] = v;
				W[w] = vw;
				minPQ.offer(w);
			}
		}

		for (var w = 1; w < V; w++) {
			var v = E[w];
			var vw = W[w];

			MST.get(v).add(new int[] { w, vw });
			MST.get(w).add(new int[] { v, vw });
		}

		var R = new int[V][][];
		for (var v = 0; v < V; v++) {
			R[v] = MST.get(v).toArray(new int[0][]);
		}

		return R;
	}
}
