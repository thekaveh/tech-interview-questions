package algoexpert.hard.knapsack_problem;
import java.util.*;

// Approach: Bottom-up 2-D DP with item backtracking.
class Solution1 {
	public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
		var n = items.length;

		var dp = new int[n + 1][capacity + 1]; // 1-based indexing where aux[i][c] stores the maximum value that can
												// be achieved with the first i items and capacity c: dp[3][c] refers to
												// using the three items (items[0], items[1], and items[2]).
		for (var at = 1; at < n + 1; at++) {
			var itemValue = items[at - 1][0];
			var itemWeight = items[at - 1][1];

			for (var c = 1; c < capacity + 1; c++) {
				var altA = dp[at - 1][c];
				var altB = (itemWeight <= c) ? itemValue + dp[at - 1][c - itemWeight] : 0;

				dp[at][c] = Math.max(altA, altB);
			}
		}

		var result = new ArrayList<List<Integer>>();
		result.add(Arrays.asList(dp[n][capacity]));

		var selected = new ArrayList<Integer>();
		for (int at = n, c = capacity; 0 < at && 0 < c; at--) {
			if (dp[at][c] == dp[at - 1][c]) {
				continue;
			}

			selected.add(0, at - 1);
			c -= items[at - 1][1];
		}
		result.add(selected);

		return result;
	}
}
