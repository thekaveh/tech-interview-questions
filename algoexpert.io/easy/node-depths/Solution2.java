import java.util.*;

class Solution2 {
    static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static int nodeDepths(BinaryTree root) {
        return solve(root, 0);
    }

    private static int solve(BinaryTree node, int depth) {
        if(node == null) { return 0; }

        return solve(node.left, depth + 1) + solve(node.right, depth + 1) + depth;
    }
}