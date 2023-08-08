import java.util.*;

class Solution1 {
    public static int maxPathSum(BinaryTree tree) {
        var ret = solve(tree);

        return Math.max(ret.inc, ret.exc);
    }

    private static TreeInfo solve(BinaryTree tree) {
        if (tree == null) { return TreeInfo.empty();  }

        var ltInfo = solve(tree.left);
        var rtInfo = solve(tree.right);

        var inc = Math.max(
            tree.value
            , Math.max(
                ltInfo.inc + tree.value
                , tree.value + rtInfo.inc
            )
        );
        var exc = Math.max(
            inc
            , Math.max(
                ltInfo.exc
                , Math.max(
                    rtInfo.exc
                    , ltInfo.inc + tree.value + rtInfo.inc
                )
            )
        );

        return new TreeInfo(inc, exc);
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class TreeInfo {
        int inc, exc;

        TreeInfo(int inc, int exc) {
            this.inc = inc;
            this.exc = exc;
        }

        static TreeInfo empty() {
            return new TreeInfo(0, Integer.MIN_VALUE);
        }
    }
}