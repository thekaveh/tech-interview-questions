package algoexpert.veryhard.a_star_algorithm;
import java.util.*;

// Approach: A* with Manhattan heuristic using Node objects and HashMap.
class Solution1 {
	static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public int[] toArray() {
			return new int[] { this.r, this.c };
		}

		public int heuristicDistTo(Node that) {
			return Math.abs(that.r - this.r) + Math.abs(that.c - this.c);
		}

		public int totalDistTo(Node that, Map<Node, Integer> srcDistTo) {
			return srcDistTo.get(this) + this.heuristicDistTo(that);
		}

		@Override
		public int hashCode() {
			return Integer.hashCode(this.r) + 31 * Integer.hashCode(this.c);
		}

		@Override
		public boolean equals(Object o) {
			var that = (Node) o;
			return this.r == that.r && this.c == that.c;
		}

		public Node[] adj() {
			return new Node[] {
					new Node(this.r - 1, this.c), new Node(this.r, this.c - 1), new Node(this.r + 1, this.c),
					new Node(this.r, this.c + 1)
			};
		}

		public boolean isValid(int[][] G) {
			var R = G.length;
			var C = G[0].length;

			if (this.r < 0 || R <= this.r) {
				return false;
			}
			if (this.c < 0 || C <= this.c) {
				return false;
			}
			if (G[this.r][this.c] == 1) {
				return false;
			}

			return true;
		}
	}

	public int[][] aStarAlgorithm(int srcR, int srcC, int dstR, int dstC, int[][] G) {
		var R = G.length;
		var C = G[0].length;

		var nil = new Node(-1, -1);
		var src = new Node(srcR, srcC);
		var dst = new Node(dstR, dstC);

		var pathTo = new HashMap<Node, Node>();
		var srcDistTo = new HashMap<Node, Integer>();
		var PQ = new PriorityQueue<Node>((v, w) -> v.totalDistTo(dst, srcDistTo) - w.totalDistTo(dst, srcDistTo));

		for (var r = 0; r < R; r++) {
			for (var c = 0; c < C; c++) {
				var v = new Node(r, c);

				pathTo.put(v, nil);
				srcDistTo.put(v, Integer.MAX_VALUE);
			}
		}

		PQ.offer(src);
		srcDistTo.put(src, 0);

		while (!PQ.isEmpty()) {
			var v = PQ.poll();

			if (v.equals(dst)) {
				break;
			}

			for (var w : v.adj()) {
				if (!w.isValid(G)) {
					continue;
				}

				var altSrcDistToW = srcDistTo.get(v) + 1;
				if (altSrcDistToW < srcDistTo.get(w)) {
					PQ.offer(w);
					pathTo.put(w, v);
					srcDistTo.put(w, altSrcDistToW);
				}
			}
		}

		var path = new LinkedList<Node>();
		for (var v = dst; !v.equals(nil); v = pathTo.get(v)) {
			path.push(v);
		}

		if (!path.peek().equals(src)) {
			return new int[0][2];
		}

		return path.stream().map(node -> node.toArray()).toArray(n -> new int[n][2]);
	}
}
