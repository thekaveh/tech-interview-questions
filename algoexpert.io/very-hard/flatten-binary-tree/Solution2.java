import java.util.*;

class Solution2 {
    public static BinaryTree flattenBinaryTree(BinaryTree root) {
        return flatten(root)[0];
    }

    private static BinaryTree[] flatten(BinaryTree node) {
        var R = new BinaryTree[2];

        if (node.left == null) {
            R[0] = node;
        } else {
            var X = flatten(node.left);

            X[1].right = node;
            node.left = X[1];

            R[0] = X[0];
        }

        if (node.right == null) {
            R[1] = node;
        } else {
            var X = flatten(node.right);

            node.right = X[0];
            X[0].left = node;

            R[1] = X[1];
        }

        return R;
    }

    // This is the class of the input root. Do not edit it.
    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}