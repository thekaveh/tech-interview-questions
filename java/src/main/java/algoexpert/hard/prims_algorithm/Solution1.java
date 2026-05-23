package algoexpert.hard.prims_algorithm;
import java.util.*;

// Approach: Eager Prim with min-heap of crossing edges.
class Solution1 {
	public int[][][] primsAlgorithm(int[][][] G) {
		var V = G.length;
		var M = new boolean[V];
		var MST = new ArrayList<ArrayList<int[]>>();
		var minPQ = new PriorityQueue<int[]>((v, w) -> v[2] - w[2]);

		for (var v = 0; v < V; v++) {
			MST.add(v, new ArrayList<>());
		}

		visit(0, M, minPQ, G);

		while (!minPQ.isEmpty()) {
			var e = minPQ.poll();

			var v = e[0];
			var w = e[1];
			var vw = e[2];

			if (M[v] && M[w]) {
				continue;
			}

			MST.get(v).add(new int[] { w, vw });
			MST.get(w).add(new int[] { v, vw });

			if (!M[v]) {
				visit(v, M, minPQ, G);
			}
			if (!M[w]) {
				visit(w, M, minPQ, G);
			}
		}

		var R = new int[V][][];
		for (var v = 0; v < V; v++) {
			R[v] = MST.get(v).toArray(new int[0][]);
		}

		return R;
	}

	private static void visit(int v, boolean[] M, PriorityQueue<int[]> minPQ, int[][][] G) {
		M[v] = true;

		for (var e : G[v]) {
			var w = e[0];
			var vw = e[1];

			if (M[w]) {
				continue;
			}

			minPQ.offer(new int[] { v, w, vw });
		}
	}
}
