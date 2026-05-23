package algoexpert.hard.maximum_sum_submatrix;
import java.util.*;

// Approach: TODO.
class Solution1 {
	public int maximumSumSubmatrix(int[][] M, int size) {
		var R = M.length;
		var C = M[0].length;

		var max = Integer.MIN_VALUE;

		for (var r = 0; r <= R - size; r++) {
			for (var c = 0; c <= C - size; c++) {
				var sum = 0;

				for (var i = 0; i < size; i++) {
					for (var j = 0; j < size; j++) {
						sum += M[r + i][c + j];
					}
				}

				max = Math.max(max, sum);
			}
		}

		return max;
	}
}
