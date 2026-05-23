package algoexpert.medium.binary_tree_diameter;
import java.util.*;

// Approach: DFS returning (height, diameter) pair.
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
        private final int height;
        private final int diameter;

        public TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    private static TreeInfo solve(BinaryTree tree) {
        if(tree == null) { return new TreeInfo(-1, -1); }

        var ltInfo = solve(tree.left);
        var rtInfo = solve(tree.right);

        var height = Math.max(ltInfo.height, rtInfo.height) + 1;
        var diameter = Math.max(
            Math.max(
                ltInfo.diameter
                , rtInfo.diameter
            )
            , ltInfo.height + rtInfo.height + 2
        );

        return new TreeInfo(height, diameter);
    }

    public int binaryTreeDiameter(BinaryTree tree) {
        return solve(tree).diameter;
    }
}
