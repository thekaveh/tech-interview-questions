package algoexpert.veryhard.all_kinds_of_node_depths;
import java.util.*;

// Approach: Single-pass DFS accumulating running depth sum.
class Solution3 {
    // O(log(n)) time | O(h) space
    public static int allKindsOfNodeDepths(BinaryTree root) {
        return solve(root, 0, 0);
    }

    private static int solve(BinaryTree node, int sum, int depth) {
        if (node == null) {
            return 0;
        }

        sum += depth;

        return sum + solve(node.left, sum, depth + 1) + solve(node.right, sum, depth + 1);
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
