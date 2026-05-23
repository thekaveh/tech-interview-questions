package algoexpert.hard.laptop_rentals;
import java.util.*;

// Approach: Sort by start + min-heap of end times.
class Solution1 {
	public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
		var N = times.size();

		if (N == 0) {
			return 0;
		}

		times.sort((v, w) -> v.get(0) - w.get(0));

		var minPQ = new PriorityQueue<Integer>();

		minPQ.offer(times.get(0).get(1));

		for (var at = 1; at < N; at++) {
			var v = times.get(at);

			var vLo = v.get(0);

			if (minPQ.peek() <= vLo) {
				minPQ.poll();
			}

			minPQ.offer(v.get(1));
		}

		return minPQ.size();
	}
}
