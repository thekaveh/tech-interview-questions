package algoexpert.medium.symmetrical_tree;
import java.util.*;

// Approach: TODO.
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

    public boolean symmetricalTree(BinaryTree tree) {
        return solve(tree.left, tree.right);
    }

    private static boolean solve(BinaryTree left, BinaryTree right) {
        if (left != null && right != null && left.value == right.value) {
            return solve(left.left, right.right) && solve(left.right, right.left);
        }

        return left == right;
    }
}
