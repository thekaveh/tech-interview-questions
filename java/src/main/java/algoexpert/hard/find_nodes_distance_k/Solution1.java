package algoexpert.hard.find_nodes_distance_k;
import java.util.*;

// Approach: TODO.
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

	public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
		var parents = new HashMap<Integer, BinaryTree>();
		var visited = new HashMap<Integer, Boolean>();

		populate(tree, parents, null);

		var u = findNode(tree, parents, target);

		var Q = new LinkedList<BinaryTree>();
		Q.offer(u);
		visited.put(u.value, true);

		while (!Q.isEmpty() && 0 < k) {
			var L = Q.size();

			for (var at = 0; at < L; at++) {
				var v = Q.poll();

				for (var w : new BinaryTree[] { parents.get(v.value), v.left, v.right }) {
					if (w == null) {
						continue;
					}
					if (visited.getOrDefault(w.value, false)) {
						continue;
					}

					Q.offer(w);
					visited.put(w.value, true);
				}
			}

			k--;
		}

		var result = new ArrayList<Integer>();
		for (var v : Q) {
			result.add(v.value);
		}

		return result;
	}

	private static void populate(BinaryTree node, Map<Integer, BinaryTree> parents, BinaryTree parent) {
		if (node == null) {
			return;
		}

		parents.put(node.value, parent);

		populate(node.left, parents, node);
		populate(node.right, parents, node);
	}

	private static BinaryTree findNode(BinaryTree tree, Map<Integer, BinaryTree> parents, int target) {
		if (tree.value == target) {
			return tree;
		}

		var parent = parents.get(target);

		if (parent.left != null && parent.left.value == target) {
			return parent.left;
		} else if (parent.right != null && parent.right.value == target) {
			return parent.right;
		}

		return null;
	}
}
