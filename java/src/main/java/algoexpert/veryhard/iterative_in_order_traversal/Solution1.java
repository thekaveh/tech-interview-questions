package algoexpert.veryhard.iterative_in_order_traversal;
import java.util.function.Function;
import java.util.*;

// Approach: TODO.
class Solution1 {
	public static void iterativeInOrderTraversal(BinaryTree tree, Function<BinaryTree, Void> f) {
		BinaryTree x = tree, w = null;

		while (x != null) {
			if (w == null || w == x.parent) {
				if (x.left != null) {
					w = x;
					x = x.left;
				} else {
					f.apply(x);

					w = x;
					x = (x.right != null) ? x.right : x.parent;
				}
			} else if (w == x.left) {
				f.apply(x);

				w = x;
				x = (x.right != null) ? x.right : x.parent;
			} else if (w == x.right) {
				w = x;
				x = x.parent;
			}
		}
	}

	static class BinaryTree {
		public int value;
		public BinaryTree left;
		public BinaryTree right;
		public BinaryTree parent;

		public BinaryTree(int value) {
			this.value = value;
		}

		public BinaryTree(int value, BinaryTree parent) {
			this.value = value;
			this.parent = parent;
		}
	}
}
