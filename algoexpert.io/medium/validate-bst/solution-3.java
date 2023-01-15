import java.util.*;

class Program {
    public static boolean validateBst(BST tree) {
        return solve(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean solve(BST tree, int min, int max) {
        if(tree == null) { return true; }

        if(max <= tree.value) { return false; }
        if(tree.value < min) { return false; }

        if(!solve(tree.left, min, tree.value)) { return false; }
        if(!solve(tree.right, tree.value, max)) { return false; }

        return true;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}