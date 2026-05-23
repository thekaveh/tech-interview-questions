package algoexpert.medium.split_binary_tree;
import java.util.*;

// Approach: DFS computing subtree sums, flag when half-sum is found.
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

    static class TreeInfo {
        int sum;
        boolean canSplit;

        public TreeInfo(boolean canSplit, int sum) {
            this.sum = sum;
            this.canSplit = canSplit;
        }
    }

    public int splitBinaryTree(BinaryTree tree) {
        var sum = sum(tree);

        if (sum % 2 != 0) {
            return 0;
        }

        var expectedSum = sum / 2;

        return solve(tree, expectedSum).canSplit ? expectedSum : 0;
    }

    private static TreeInfo solve(BinaryTree tree, int expectedSum) {
        if (tree == null) {
            return new TreeInfo(false, 0);
        }

        var lt = solve(tree.left, expectedSum);
        var rt = solve(tree.right, expectedSum);

        var sum = tree.value + lt.sum + rt.sum;
        var canSplit = lt.canSplit || rt.canSplit || sum == expectedSum;

        return new TreeInfo(canSplit, sum);
    }

    private static int sum(BinaryTree tree) {
        if (tree == null) {
            return 0;
        }

        return tree.value + sum(tree.left) + sum(tree.right);
    }
}
