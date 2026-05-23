package algoexpert.veryhard.merge_sorted_arrays;
import java.util.*;

// Approach: Min-heap of int[] index pairs.
class Solution2 {
	public static List<Integer> mergeSortedArrays(List<List<Integer>> A) {
		var R = new ArrayList<Integer>();
		var minPQ = new PriorityQueue<int[]>((v, w) -> A.get(v[0]).get(v[1]) - A.get(w[0]).get(w[1]));

		for (var r = 0; r < A.size(); r++) {
			minPQ.offer(new int[] { r, 0 });
		}

		while (!minPQ.isEmpty()) {
			var v = minPQ.poll();

			var r = v[0];
			var c = v[1];

			R.add(A.get(r).get(c));

			if (c + 1 < A.get(r).size()) {
				minPQ.offer(new int[] { r, c + 1 });
			}
		}

		return R;
	}
}
