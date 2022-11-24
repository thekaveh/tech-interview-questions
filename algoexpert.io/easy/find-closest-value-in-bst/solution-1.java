import java.util.*;

class Program {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static int findClosestValueInBst(BST tree, int target) {
        return solve(tree, target, tree.value);
    }

    private static int solve(BST tree, int target, int candidate) {
        if(tree == null) { return candidate; }

        if(Math.abs(target - tree.value) < Math.abs(target - candidate)) {
            candidate = tree.value;
        }

        if      (target < tree.value)   { return solve(tree.left, target, candidate); }
        else if (tree.value < target)   { return solve(tree.right, target, candidate); }
        else                            { return candidate; }
    }
}