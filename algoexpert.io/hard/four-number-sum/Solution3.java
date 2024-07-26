import java.util.*;

class Solution3 {
	public static List<Integer[]> fourNumberSum(int[] A, int S) {
		var N = A.length;

		var R = new ArrayList<Integer[]>();
		var M = new HashMap<Integer, List<Integer[]>>();

		for (var i = 1; i < N - 1; i++) {
			for (var j = i + 1; j < N; j++) {
				var d = S - A[i] - A[j];

				if (M.containsKey(d)) {
					for (var pair : M.get(d)) {
						R.add(new Integer[] { pair[0], pair[1], A[i], A[j] });
					}
				}
			}

			for (var k = 0; k < i; k++) {
				var s = A[i] + A[k];

				M.putIfAbsent(s, new ArrayList<>());
				M.get(s).add(new Integer[] { A[k], A[i] });
			}
		}

		return R;
	}
}
