import java.util.*;

class Program {
	public int[][] aStarAlgorithm(int rSrc, int cSrc, int rDst, int cDst, int[][] G) {
		var R = G.length;
		var C = G[0].length;

		var nil = new int[] { -1, -1 };
		var src = new int[] { rSrc, cSrc };
		var dst = new int[] { rDst, cDst };

		var P = new int[R][C][2];
		var D = new int[R][C];

		var minPQ = new PriorityQueue<int[]>((v, w) -> (D[v[0]][v[1]] + h(v, dst)) - (D[w[0]][w[1]] + h(w, dst)));

		for (var r = 0; r < R; r++) {
			for (var c = 0; c < C; c++) {
				P[r][c] = Arrays.copyOf(nil, nil.length);
				D[r][c] = Integer.MAX_VALUE;
			}
		}

		minPQ.offer(src);
		D[rSrc][cSrc] = 0;

		while (!minPQ.isEmpty()) {
			var v = minPQ.poll();

			var rV = v[0];
			var cV = v[1];

			if (Arrays.equals(v, dst)) {
				break;
			}

			for (var w : adj(v)) {
				var rW = w[0];
				var cW = w[1];

				if (rW < 0 || R <= rW) {
					continue;
				}
				if (cW < 0 || C <= cW) {
					continue;
				}
				if (G[rW][cW] == 1) {
					continue;
				}

				var altDw = D[rV][cV] + 1;
				if (altDw < D[rW][cW]) {
					P[rW][cW] = Arrays.copyOf(v, v.length);
					D[rW][cW] = altDw;

					minPQ.offer(w);
				}
			}
		}

		var path = new LinkedList<int[]>();
		for (var x = dst; !Arrays.equals(x, nil); x = P[x[0]][x[1]]) {
			path.push(x);
		}

		if (!Arrays.equals(path.peek(), src)) {
			return new int[0][2];
		}

		return path.toArray(n -> new int[n][2]);
	}

	private static int[][] adj(int[] v) {
		var r = v[0];
		var c = v[1];

		return new int[][] {
				new int[] { r - 1, c },
				new int[] { r + 1, c },
				new int[] { r, c + 1 },
				new int[] { r, c - 1 },
		};
	}

	private static int h(int[] v, int[] w) {
		return Math.abs(v[0] - w[0]) + Math.abs(v[1] - w[1]);
	}
}