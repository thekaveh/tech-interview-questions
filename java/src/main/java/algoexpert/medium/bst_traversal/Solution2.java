package algoexpert.medium.bst_traversal;
import java.util.*;

// Approach: Recursive traversal with explicit child checks.
class Solution2 {
    public static List<Integer> inOrderTraverse(BST tree, List<Integer> Q) {
        if(tree.left != null) { inOrderTraverse(tree.left, Q); }
        
        Q.add(tree.value);

        if(tree.right != null) { inOrderTraverse(tree.right, Q); }

        return Q;
    }

    public static List<Integer> preOrderTraverse(BST tree, List<Integer> Q) {
        Q.add(tree.value);

        if(tree.left != null) { preOrderTraverse(tree.left, Q); }

        if(tree.right != null) { preOrderTraverse(tree.right, Q); }

        return Q;
    }

    public static List<Integer> postOrderTraverse(BST tree, List<Integer> Q) {
        if(tree.left != null) { postOrderTraverse(tree.left, Q); }

        if(tree.right != null) { postOrderTraverse(tree.right, Q); }
        
        Q.add(tree.value);

        return Q;
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
