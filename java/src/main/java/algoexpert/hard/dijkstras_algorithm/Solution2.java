package algoexpert.hard.dijkstras_algorithm;
import java.util.*;

// Approach: Min-heap Dijkstra with explicit remove.
class Solution2 {
	public int[] dijkstrasAlgorithm(int s, int[][][] E) {
		int N = E.length;
		int[] D = new int[N];
		var minPQ = new PriorityQueue<Integer>((v, w) -> D[v] - D[w]);

		Arrays.fill(D, Integer.MAX_VALUE);
		D[s] = 0;
		minPQ.offer(s);

		while (!minPQ.isEmpty()) {
			var v = minPQ.poll();

			for (var e : E[v]) {
				var w = e[0];
				var vw = e[1];
				var altDw = D[v] + vw;

				if (D[w] <= altDw) {
					continue;
				}

				D[w] = altDw;
				if (minPQ.contains(w)) {
					minPQ.remove(w);
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
