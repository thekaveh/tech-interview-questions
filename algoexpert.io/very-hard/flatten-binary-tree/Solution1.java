import java.util.*;

class Solution1 {
    public static BinaryTree flattenBinaryTree(BinaryTree root) {
        var M = new ArrayList<BinaryTree>();
        inOrder(root, M);
        int N = M.size();

        for (int i = 0; i < N - 1; i++) {
            var left = M.get(i);
            var right = M.get(i + 1);

            left.right = right;
            right.left = left;
        }

        return M.get(0);
    }

    private static void inOrder(BinaryTree node, List<BinaryTree> M) {
        if (node == null) { return; }

        inOrder(node.left, M);
        M.add(node);
        inOrder(node.right, M);
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