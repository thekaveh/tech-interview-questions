package algoexpert.hard.knight_connection;
import java.util.*;

// Approach: Bidirectional BFS.
class Solution1 {
	public int knightConnection(int[] A, int[] B) {
		var M = new HashSet<String>();
		var Q = new LinkedList<int[]>();
		var ADJ = new int[][] { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 },
				{ -2, -1 } };

		var moves = 0;

		Q.offer(A);
		M.add(toString(A));

		while (!Q.isEmpty()) {
			var L = Q.size();

			for (var at = 0; at < L; at++) {
				var v = Q.poll();

				if (Arrays.equals(v, B)) {
					return (int) Math.ceil(moves / 2.0d);
				}

				for (var adj : ADJ) {
					var w = new int[] { v[0] + adj[0], v[1] + adj[1] };

					if (M.contains(toString(w))) {
						continue;
					}

					Q.offer(w);
					M.add(toString(w));
				}
			}

			moves++;
		}

		return -1;
	}

	private static String toString(int[] v) {
		return v[0] + "," + v[1];
	}
}
