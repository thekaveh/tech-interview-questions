package algoexpert.hard.maximum_sum_submatrix;
import java.util.*;

// Approach: 2-D prefix sums for O(1) sub-matrix queries.
class Solution2 {
	public int maximumSumSubmatrix(int[][] M, int D) {
		var R = M.length;
		var C = M[0].length;

		var S = new int[R + 1][C + 1]; // S[r][c] represents the sum of the submatrix from the top-left corner (0, 0)
										// to the position (r-1, c-1) in the original matrix
		for (var r = 1; r <= R; r++) {
			for (var c = 1; c <= C; c++) {
				S[r][c] = M[r - 1][c - 1] + S[r - 1][c] + S[r][c - 1] - S[r - 1][c - 1];
			}
		}

		var max = Integer.MIN_VALUE;

		for (var r = D; r <= R; r++) {
			for (var c = D; c <= C; c++) {
				var sum = S[r][c] - S[r - D][c] - S[r][c - D] + S[r - D][c - D];
				max = Math.max(max, sum);
			}
		}

		return max;
	}
}
