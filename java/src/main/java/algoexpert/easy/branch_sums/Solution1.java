package algoexpert.easy.branch_sums;
import java.util.*;

// Approach: Recursive DFS, isLeaf helper.
class Solution1 {
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        boolean isLeaf() { return this.left == null && this.right == null; }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        var R = new ArrayList<Integer>();
    
        solve(root, R, 0);
    
        return R;
    }
    
    private static void solve(BinaryTree node, List<Integer> R, int r) {
        if(node == null) { return; }

        r += node.value;

        if(node.isLeaf()) { R.add(r); return; }
    
        solve(node.left, R, r);
        solve(node.right, R, r);
    }
}
