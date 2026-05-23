package algoexpert.hard.largest_island;
import java.util.*;

// Approach: DFS island labeling + water-cell neighbor union.
class Solution1 {
	public int largestIsland(int[][] A) {
		var R = A.length;
		var C = A[0].length;

		var CC = new int[R][C];
		var M = new boolean[R][C];
		var CCC = new HashMap<Integer, Integer>();

		for (var r = 0; r < R; r++) {
			Arrays.fill(CC[r], -1);
		}

		var cc = 0;
		for (var r = 0; r < R; r++) {
			for (var c = 0; c < C; c++) {
				if (!canVisit(r, c, A, M)) {
					continue;
				}

				visit(r, c, A, M, CC, CCC, cc++);
			}
		}

		var largest = Integer.MIN_VALUE;

		for (var r = 0; r < R; r++) {
			for (var c = 0; c < C; c++) {
				if (A[r][c] == 0) {
					continue;
				}

				var adjCC = new HashSet<Integer>();

				for (var w : adj(r, c)) {
					if (w[0] < 0 || R <= w[0]) {
						continue;
					}
					if (w[1] < 0 || C <= w[1]) {
						continue;
					}
					if (A[w[0]][w[1]] == 1) {
						continue;
					}

					adjCC.add(CC[w[0]][w[1]]);
				}

				var current = 0;
				for (var adjcc : adjCC) {
					current += CCC.get(adjcc);
				}
				largest = Math.max(largest, current + 1);
			}
		}

		return largest;
	}

	private static int[][] adj(int r, int c) {
		return new int[][] {
				{ r - 1, c }, { r + 1, c }, { r, c - 1 }, { r, c + 1 }
		};
	}

	private static boolean canVisit(int r, int c, int[][] A, boolean[][] M) {
		var R = A.length;
		var C = A[0].length;

		if (r < 0 || R <= r) {
			return false;
		}
		if (c < 0 || C <= c) {
			return false;
		}

		if (A[r][c] == 1) {
			return false;
		}
		if (M[r][c]) {
			return false;
		}

		return true;
	}

	private static void visit(int r, int c, int[][] A, boolean[][] M, int[][] CC, Map<Integer, Integer> CCC, int cc) {
		var R = A.length;
		var C = A[0].length;

		M[r][c] = true;
		CC[r][c] = cc;
		CCC.put(cc, CCC.getOrDefault(cc, 0) + 1);

		for (var w : adj(r, c)) {
			if (!canVisit(w[0], w[1], A, M)) {
				continue;
			}

			visit(w[0], w[1], A, M, CC, CCC, cc);
		}
	}
}
