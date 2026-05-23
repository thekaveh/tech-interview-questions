package algoexpert.veryhard.line_through_points;
import java.util.*;

// Approach: TODO.
class Solution1 {
	public int lineThroughPoints(int[][] points) {
		var max = 1;
		var N = points.length;

		for (var idxA = 0; idxA < N - 1; idxA++) {
			var a = points[idxA];
			var M = new HashMap<String, Integer>();

			for (var idxB = idxA + 1; idxB < N; idxB++) {
				var b = points[idxB];

				var abSlope = toString(slope(a, b));

				M.put(abSlope, M.getOrDefault(abSlope, 1) + 1);
			}

			for (var entry : M.entrySet()) {
				max = Math.max(max, entry.getValue());
			}
		}

		return max;
	}

	private static String toString(int[] x) {
		return String.valueOf(x[0]) + ":" + String.valueOf(x[1]);
	}

	private static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}

		return gcd(b, a % b);
	}

	private static int[] slope(int[] a, int[] b) {
		var slope = new int[2];

		if (a[0] != b[0]) {
			var dX = a[0] - b[0];
			var dY = a[1] - b[1];

			var gcd = gcd(Math.abs(dX), Math.abs(dY));

			dX = dX / gcd;
			dY = dY / gcd;

			if (dX < 0) {
				dX *= -1;
				dY *= -1;
			} else if (dX == 0 && dY < 0) {
				dY *= -1;
			}

			slope[0] = dX;
			slope[1] = dY;
		} else {
			slope[0] = 0;
			slope[1] = 1;
		}

		return slope;
	}
}
