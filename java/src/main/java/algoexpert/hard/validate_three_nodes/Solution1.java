package algoexpert.hard.validate_three_nodes;
import java.util.*;

// Approach: BST-guided descendant search (iterative).
class Solution1 {
	// This is an input class. Do not edit.
	static class BST {
		public int value;
		public BST left = null;
		public BST right = null;

		public BST(int value) {
			this.value = value;
		}
	}

	public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
		if (isDescendant(nodeTwo, nodeOne)) {
			return isDescendant(nodeThree, nodeTwo);
		}
		if (isDescendant(nodeTwo, nodeThree)) {
			return isDescendant(nodeOne, nodeTwo);
		}

		return false;
	}

	// O(h) time | O(1) space
	private static boolean isDescendant(BST ancestor, BST descendant) {
		while (ancestor != null && ancestor != descendant) {
			ancestor = (descendant.value < ancestor.value) ? ancestor.left : ancestor.right;
		}

		return ancestor == descendant;
	}
}
