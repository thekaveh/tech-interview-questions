import java.util.*;

class Solution2 {
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        var R = new ArrayList<Integer>();

        solve(root, 0, R);

        return R;
    }

    private static void solve(BinaryTree node, int T, List<Integer> R) {
        if(node == null) { return; }

        T += node.value;

        if(node.left == null && node.right == null) { R.add(T); return; }

        solve(node.left, T, R);
        solve(node.right, T, R);
    }
}