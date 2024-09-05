import java.util.*;

class Solution2 {
	public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
		var N = times.size();

		if (N == 0) {
			return 0;
		}

		times.sort((v, w) -> v.get(0) - w.get(0));

		var minPQ = new PriorityQueue<ArrayList<Integer>>((v, w) -> v.get(1) - w.get(1));

		minPQ.offer(times.get(0));

		for (var at = 1; at < N; at++) {
			var v = times.get(at);
			var vLo = v.get(0);

			var w = minPQ.peek();
			var wHi = w.get(1);

			if (wHi <= vLo) {
				minPQ.poll();
			}

			minPQ.offer(v);
		}

		return minPQ.size();
	}
}