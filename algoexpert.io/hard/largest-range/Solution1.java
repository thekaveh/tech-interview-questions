import java.util.*;

class Solution1 {
	public static int[] largestRange(int[] A) {
		var rKey = 0;
		var rLenMax = 0;
		var rKeyMax = 0;

		var R = new HashMap<Integer, int[]>();
		var M = new HashMap<Integer, Boolean>();

		for (var a : A) {
			M.put(a, false);
		}

		for (var a : A) {
			if (!canVisit(a, M)) {
				continue;
			}

			if (!R.containsKey(rKey)) {
				R.put(rKey, new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE });
			}

			var rLen = visit(a, rKey, M, R);

			if (rLenMax < rLen) {
				rLenMax = rLen;
				rKeyMax = rKey;
			}

			rKey++;
		}

		return R.get(rKeyMax);
	}

	private static boolean canVisit(int v, Map<Integer, Boolean> M) {
		return M.containsKey(v) && M.get(v) == false;
	}

	private static int[] adj(int v) {
		return new int[] { v - 1, v + 1 };
	}

	private static int visit(int v, int rKey, Map<Integer, Boolean> M, Map<Integer, int[]> R) {
		M.put(v, true);

		var r = R.get(rKey);

		if (v < r[0]) {
			r[0] = v;
		}
		if (r[1] < v) {
			r[1] = v;
		}

		for (var w : adj(v)) {
			if (!canVisit(w, M)) {
				continue;
			}

			visit(w, rKey, M, R);
		}

		return r[1] - r[0] + 1;
	}
}