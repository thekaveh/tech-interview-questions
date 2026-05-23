package algoexpert.hard.sum_bsts;
import java.util.*;

// Approach: Post-order DFS tracking BST validity, range, size, and subtree sums.
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
        boolean isBst;
        int min;
        int max;
        int size;
        int sum;
        int total;

        public TreeInfo(boolean isBst, int min, int max, int size, int sum, int total) {
            this.isBst = isBst;
            this.min = min;
            this.max = max;
            this.size = size;
            this.sum = sum;
            this.total = total;
        }
    }

    public int sumBsts(BinaryTree tree) {
        return solve(tree).total;
    }

    private static TreeInfo solve(BinaryTree tree) {
        if (tree == null) {
            return new TreeInfo(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 0, 0);
        }

        var lt = solve(tree.left);
        var rt = solve(tree.right);

        var isBst = lt.isBst && rt.isBst && lt.max < tree.value && tree.value <= rt.min;

        var min = Math.min(tree.value, Math.min(lt.min, rt.min));
        var max = Math.max(tree.value, Math.max(lt.max, rt.max));

        var size = isBst ? 1 + lt.size + rt.size : 0;
        var sum = isBst ? tree.value + lt.sum + rt.sum : 0;

        var total = size >= 3 ? sum : lt.total + rt.total;

        return new TreeInfo(isBst, min, max, size, sum, total);
    }
}
