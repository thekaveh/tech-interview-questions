package algoexpert.hard.solve_sudoku;
import java.util.*;

// Approach: TODO.
class Solution1 {
	public ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> B) {
		solve(0, 0, B);

		return B;
	}

	private static boolean solve(int r, int c, ArrayList<ArrayList<Integer>> B) {
		var R = B.size();
		var C = B.get(0).size();

		if (c == C) {
			r++;
			c = 0;

			if (r == R) {
				return true;
			}
		}

		if (B.get(r).get(c) == 0) {
			return solveForPos(r, c, B);
		}

		return solve(r, c + 1, B);
	}

	private static boolean solveForPos(int r, int c, ArrayList<ArrayList<Integer>> B) {
		for (var d = 1; d < 10; d++) {
			if (isValid(d, r, c, B)) {
				B.get(r).set(c, d);

				if (solve(r, c + 1, B)) {
					return true;
				}
			}
		}

		B.get(r).set(c, 0);
		return false;
	}

	private static boolean isValid(int d, int r, int c, ArrayList<ArrayList<Integer>> B) {
		var R = B.size();

		var rValid = !B.get(r).contains(d);
		var cValid = true;

		for (var _r = 0; _r < R; _r++) {
			if (B.get(_r).get(c) == d) {
				cValid = false;
			}
		}

		if (!rValid || !cValid) {
			return false;
		}

		var rLo = (r / 3) * 3;
		var cLo = (c / 3) * 3;

		for (var rDelt = 0; rDelt < 3; rDelt++) {
			for (var cDelt = 0; cDelt < 3; cDelt++) {
				if (B.get(rLo + rDelt).get(cLo + cDelt) == d) {
					return false;
				}
			}
		}

		return true;
	}
}
