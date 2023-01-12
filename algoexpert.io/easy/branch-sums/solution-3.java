import java.util.*;

class Program {
    // This is the class of the input root. Do not edit it.
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

        solve(root, R, 0);

        return R;
    }

    private static void solve(BinaryTree tree, List<Integer> R, int T) {
        T += tree.value;
        
        if(tree.left != null) 					    { solve(tree.left, R, T); }
        if(tree.right != null)					    { solve(tree.right, R, T); }
        if(tree.left == null && tree.right == null) { R.add(T); }
    }
}