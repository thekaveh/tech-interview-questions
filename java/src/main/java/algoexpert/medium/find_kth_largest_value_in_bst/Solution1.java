package algoexpert.medium.find_kth_largest_value_in_bst;
import java.util.*;

// Approach: Reverse in-order into queue, then skip k-1.
class Solution1 {
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
        var Q = new LinkedList<Integer>();

        traverseRNL(tree, Q);

        while(k > 1) { Q.poll(); k--; }

        return Q.poll();
    }

    private static void traverseRNL(BST tree, Queue<Integer> Q) {
        if(tree == null) { return; }

        traverseRNL(tree.right, Q);

        Q.offer(tree.value);

        traverseRNL(tree.left, Q);
    }
}
