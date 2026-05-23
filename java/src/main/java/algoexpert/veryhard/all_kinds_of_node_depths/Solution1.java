package algoexpert.veryhard.all_kinds_of_node_depths;
import java.util.*;

// Approach: Iterative DFS per node computing subtree depth sums.
class Solution1 {
	// O(n.log(n)) time | O(h) space
	public static int allKindsOfNodeDepths(BinaryTree root) {
		var sum = 0;

		var S = new Stack<BinaryTree>();
		S.push(root);

		while (!S.isEmpty()) {
			var v = S.pop();

			sum += solve(v, 0);

			for (var w : new BinaryTree[] { v.right, v.left }) {
				if (w == null) {
					continue;
				}

				S.push(w);
			}
		}

		return sum;
	}

	private static int solve(BinaryTree node, int depth) {
		if (node == null) {
			return 0;
		}

		return depth + solve(node.left, depth + 1) + solve(node.right, depth + 1);
	}

	static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
			left = null;
			right = null;
		}
	}
}
