import java.util.*;

class Solution1 {
    public static List<Integer> inOrderTraverse(BST tree, List<Integer> Q) {
        if(tree == null) { return Q; }

        inOrderTraverse(tree.left, Q);
        
        Q.add(tree.value);

        inOrderTraverse(tree.right, Q);

        return Q;
    }

    public static List<Integer> preOrderTraverse(BST tree, List<Integer> Q) {
        if(tree == null) { return Q; }
        
        Q.add(tree.value);

        preOrderTraverse(tree.left, Q);

        preOrderTraverse(tree.right, Q);

        return Q;
    }

    public static List<Integer> postOrderTraverse(BST tree, List<Integer> Q) {
        if(tree == null) { return Q; }

        postOrderTraverse(tree.left, Q);

        postOrderTraverse(tree.right, Q);
        
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