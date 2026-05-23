package algoexpert.veryhard.detect_arbitrage;
import java.util.*;

// Approach: TODO.
class Solution1 {
	public boolean detectArbitrage(ArrayList<ArrayList<Double>> G) {
		var V = G.size();

		for (var v = 0; v < V; v++) {
			for (var w = 0; w < V; w++) {
				G.get(v).set(w, -Math.log10(G.get(v).get(w)));
			}
		}

		var D = new double[V];
		Arrays.fill(D, Double.MAX_VALUE);
		D[0] = 0;

		for (var pass = 0; pass < V; pass++) {
			var updated = false;

			for (var v = 0; v < V; v++) {
				for (var w = 0; w < V; w++) {
					var vw = G.get(v).get(w);
					var altDw = D[v] + vw;

					if (altDw < D[w]) {
						D[w] = altDw;
						updated = true;
					}
				}
			}

			if (!updated) {
				return false;
			}
		}

		return true;
	}
}
