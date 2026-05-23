package algoexpert.veryhard.all_kinds_of_node_depths;
import java.util.*;

// Approach: Recursive: for each node, add its subtree depth sum.
class Solution2 {
    // O(n.log(n)) time | O(h) space
    public static int allKindsOfNodeDepths(BinaryTree root) {
        if (root == null) {
            return 0;
        }

        return solve(root, 0) + allKindsOfNodeDepths(root.left) + allKindsOfNodeDepths(root.right);
    }

    private static int solve(BinaryTree node, int depth) {
        if (node == null) {
            return 0;
        }

        return depth + solve(node.left, depth + 1) + solve(node.right, depth + 1);
    }

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
}
