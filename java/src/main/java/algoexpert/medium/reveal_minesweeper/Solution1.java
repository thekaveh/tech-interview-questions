package algoexpert.medium.reveal_minesweeper;
import java.util.*;

// Approach: Recursive DFS flood-fill from clicked cell.
class Solution1 {
	public String[][] revealMinesweeper(String[][] board, int row, int column) {
		if (board[row][column].equals("M")) {
			board[row][column] = "X";

			return board;
		}

		if (!board[row][column].equals("H")) {
			return board;
		}

		var mines = 0;
		for (var adj : adj(row, column, board)) {
			if (board[adj[0]][adj[1]].equals("M")) {
				mines++;
			}
		}

		if (0 < mines) {
			board[row][column] = Integer.toString(mines);
		} else {
			board[row][column] = "0";

			for (var adj : adj(row, column, board)) {
				if (board[adj[0]][adj[1]].equals("H")) {
					revealMinesweeper(board, adj[0], adj[1]);
				}
			}
		}

		return board;
	}

	private static List<int[]> adj(int r, int c, String[][] B) {
		var R = B.length;
		var C = B[0].length;
		var neighbors = new ArrayList<int[]>();

		for (var v : new int[][] {
				new int[] { r - 1, c - 1 }, new int[] { r - 1, c }, new int[] { r - 1, c + 1 }, new int[] { r, c - 1 },
				new int[] { r, c + 1 }, new int[] { r + 1, c - 1 }, new int[] { r + 1, c }, new int[] { r + 1, c + 1 }
		}) {
			if (v[0] < 0 || R <= v[0]) {
				continue;
			}
			if (v[1] < 0 || C <= v[1]) {
				continue;
			}

			neighbors.add(v);
		}

		return neighbors;
	}
}
