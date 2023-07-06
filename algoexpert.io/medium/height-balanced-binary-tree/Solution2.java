import java.util.*;

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

    static class TreeInfo {
        final int height;
        final boolean balanced;

        public TreeInfo(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }

    private static TreeInfo solve(BinaryTree tree) {
        if(tree == null) { return new TreeInfo(0, true); }

        var ltInfo = solve(tree.left);
        var rtInfo = solve(tree.right);

        var height = Math.max(ltInfo.height, rtInfo.height) + 1;
        var balanced = ltInfo.balanced && rtInfo.balanced && Math.abs(ltInfo.height - rtInfo.height) <= 1;

        return new TreeInfo(height, balanced);
    }

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        return solve(tree).balanced;
    }
}