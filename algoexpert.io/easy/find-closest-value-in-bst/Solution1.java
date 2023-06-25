import java.util.*;

class Solution1 {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static int findClosestValueInBst(BST tree, int v) {
        return solve(tree, v, tree.value);
    }

    private static int solve(BST tree, int v, int t) {
        if(tree == null) { return t; }

        if(Math.abs(v - tree.value) < Math.abs(v - t)) { t = tree.value; }

        if      (v < tree.value)    { return solve(tree.left, v, t); }
        else if (tree.value < v)    { return solve(tree.right, v, t); }
        else                        { return t; }
    }
}