package algoexpert.hard.maximize_expression;
import java.util.*;

// Approach: TODO.
class Solution1 {
	public int maximizeExpression(int[] A) {
		var N = A.length;

		if (N < 4) {
			return 0;
		}

		var max = Integer.MIN_VALUE;

		for (var i = 0; i < N - 3; i++) {
			var iNum = A[i];

			for (var j = i + 1; j < N - 2; j++) {
				var jNum = A[j];

				for (var k = j + 1; k < N - 1; k++) {
					var kNum = A[k];

					for (var l = k + 1; l < N; l++) {
						var lNum = A[l];

						max = Math.max(max, iNum - jNum + kNum - lNum);
					}
				}
			}
		}

		return max;
	}
}
