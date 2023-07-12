import java.util.*;

class Solution1 {
    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        var Q = new LinkedList<BinaryTree>();

        traverseLNR(tree, Q);

        for(var i = 0; i < Q.size() - 1; i++) {
            if(Q.get(i) == node) {
                return Q.get(i + 1);
            }
        }

        return null;
    }

    private static void traverseLNR(BinaryTree node, Queue<BinaryTree> Q) {
        if(node == null) { return; }
        
        traverseLNR(node.left, Q);

        Q.offer(node);

        traverseLNR(node.right, Q);
    }
}