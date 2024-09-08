import java.util.*;

class Solution1 {
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
		var leaves1 = leaves(tree1);
		var n1 = leaves1.size();

		var leaves2 = leaves(tree2);
		var n2 = leaves2.size();

		if (n1 != n2) {
			return false;
		}

		for (var at = 0; at < n1; at++) {
			if (leaves1.get(at) != leaves2.get(at)) {
				return false;
			}
		}

		return true;
	}

	private static List<Integer> leaves(BinaryTree tree) {
		var R = new ArrayList<Integer>();
		var S = new Stack<BinaryTree>();

		S.push(tree);

		while (!S.isEmpty()) {
			var v = S.pop();

			if (v.left == null && v.right == null) {
				R.add(v.value);
				continue;
			}

			for (var w : new BinaryTree[] { v.right, v.left }) {
				if (w == null) {
					continue;
				}

				S.push(w);
			}
		}

		return R;
	}
}