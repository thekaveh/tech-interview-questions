package algoexpert.medium.symmetrical_tree;
import java.util.*;

// Approach: Recursive with explicit null checks before value comparison.
class Solution3 {
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

    private static boolean solve(BinaryTree lt, BinaryTree rt) {
        if (lt == null && rt == null) {
            return true;
        }
        if (lt == null || rt == null) {
            return false;
        }

        if (lt.value != rt.value) {
            return false;
        }

        return (solve(lt.left, rt.right) && solve(lt.right, rt.left));
    }
}
