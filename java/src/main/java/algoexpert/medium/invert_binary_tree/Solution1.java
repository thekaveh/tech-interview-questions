package algoexpert.medium.invert_binary_tree;
import java.util.*;

// Approach: Recursive post-order swap.
class Solution1 {
    public static void invertBinaryTree(BinaryTree tree) {
        if(tree == null) { return; }

        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);

        var T = tree.left;
        tree.left = tree.right;
        tree.right = T;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
