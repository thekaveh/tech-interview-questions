package algoexpert.hard.dijkstras_algorithm;
import java.util.*;

// Approach: Min-heap Dijkstra with in-queue tracking.
public class Solution3 {
	public int[] dijkstrasAlgorithm(int s, int[][][] E) {
		var N = E.length;

		var D = new int[N];
		var M = new boolean[N];
		var minPQ = new PriorityQueue<Integer>((v, w) -> D[v] - D[w]);

		Arrays.fill(D, Integer.MAX_VALUE);

		D[s] = 0;
		M[s] = true;
		minPQ.offer(s);

		while (!minPQ.isEmpty()) {
			var v = minPQ.poll();
			M[v] = false;

			for (var e : E[v]) {
				var w = e[0];
				var vw = e[1];
				var altDw = D[v] + vw;

				if (D[w] <= altDw) {
					continue;
				}

				D[w] = altDw;

				if (M[w]) {
					minPQ.remove(w);
				} else {
					M[w] = true;
				}

				minPQ.offer(w);
			}
		}

		for (var v = 0; v < N; v++) {
			if (D[v] == Integer.MAX_VALUE) {
				D[v] = -1;
			}
		}

		return D;
	}
}
