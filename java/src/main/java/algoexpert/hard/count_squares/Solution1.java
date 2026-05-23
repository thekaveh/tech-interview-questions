package algoexpert.hard.count_squares;
import java.util.*;

// Approach: Point-set lookup with perpendicular midpoint.
class Solution1 {
	public int countSquares(int[][] points) {
		var count = 0;
		var M = new HashSet<String>();

		for (var point : points) {
			M.add(toString(point));
		}

		for (var a : points) {
			for (var b : points) {
				if (a == b) {
					continue;
				}

				var mid = new double[] { (a[0] + b[0]) / 2.0, (a[1] + b[1]) / 2.0 };
				var dX = a[0] - mid[0];
				var dY = a[1] - mid[1];

				var c = new double[] { mid[0] + dY, mid[1] - dX };
				var d = new double[] { mid[0] - dY, mid[1] + dX };

				if (M.contains(toString(c)) && M.contains(toString(d))) {
					count++;
				}
			}
		}

		return count / 4;
	}

	private static String toString(int[] x) {
		return String.valueOf(x[0]) + ":" + String.valueOf(x[1]);
	}

	private static String toString(double[] x) {
		if (x[0] % 1 == 0 && x[1] % 1 == 0) {
			return String.valueOf((int) x[0]) + ":" + String.valueOf((int) x[1]);
		} else {
			return String.valueOf(x[0]) + ":" + String.valueOf(x[1]);
		}
	}
}
