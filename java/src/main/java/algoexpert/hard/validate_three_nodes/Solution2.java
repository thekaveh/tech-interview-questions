package algoexpert.hard.validate_three_nodes;
import java.util.*;

// Approach: BST-guided descendant search (recursive).
class Solution2 {
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

    // O(h) time | O(h) space
    private static boolean isDescendant(BST ancestor, BST descendant) {
        if (ancestor == null) {
            return false;
        }
        if (ancestor == descendant) {
            return true;
        }

        return (descendant.value < ancestor.value) ? isDescendant(ancestor.left, descendant)
                : isDescendant(ancestor.right, descendant);
    }
}
