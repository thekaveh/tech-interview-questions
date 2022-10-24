import java.util.*;

class Program {
    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public int findKthLargestValueInBst(BST tree, int k) {
        Queue<Integer> Q = new LinkedList<>();

        traverseRNL(tree, Q);

        for(var i = 0; i < k; i++) { Q.poll(); }

        return Q.poll();
    }

    private static void traverseRNL(BST tree, Queue<Integer> Q) {
        if(tree == null) { return; }

        traverseRNL(tree.right, Q);

        Q.offer(tree.value);

        traverseRNL(tree.left, Q);
    }
}