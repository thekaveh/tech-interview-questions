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

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        if(tree == null) { return true; }

        return heightBalancedBinaryTree(tree.left)
            && heightBalancedBinaryTree(tree.right)
            && (Math.abs(height(tree.left) - height(tree.right)) <= 1);
    }

    private static int height(BinaryTree tree) {
        if(tree == null) { return 0; }

        var left_height = height(tree.left);
        var right_height = height(tree.right);

        return 1 + Math.max(left_height, right_height);
    }
}