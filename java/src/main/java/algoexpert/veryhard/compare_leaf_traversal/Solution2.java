package algoexpert.veryhard.compare_leaf_traversal;
import java.util.*;

// Approach: Two synchronized iterative DFS stacks, compare leaf by leaf.
class Solution2 {
	// This is an input class. Do not edit.
	static class BinaryTree {
		public int value;
		public BinaryTree left = null;
		public BinaryTree right = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

	public boolean compareLeafTraversal(BinaryTree tree1, BinaryTree tree2) {
		var S1 = new Stack<BinaryTree>();
		S1.push(tree1);

		var S2 = new Stack<BinaryTree>();
		S2.push(tree2);

		while (!S1.isEmpty() && !S2.isEmpty()) {
			var v1 = nextLeaf(S1);
			var v2 = nextLeaf(S2);

			if (v1.value != v2.value) {
				return false;
			}
		}

		return S1.size() == 0 && S2.size() == 0;
	}

	private static BinaryTree nextLeaf(Stack<BinaryTree> S) {
		while (!S.isEmpty()) {
			var v = S.pop();

			if (v.left == null && v.right == null) {
				return v;
			}

			for (var w : new BinaryTree[] { v.right, v.left }) {
				if (w == null) {
					continue;
				}

				S.push(w);
			}
		}

		return null;
	}
}
