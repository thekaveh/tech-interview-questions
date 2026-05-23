package algoexpert.medium.merge_binary_trees;
import java.util.*;

// Approach: TODO.
class Solution2 {
    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public BinaryTree mergeBinaryTrees(BinaryTree A, BinaryTree B) {
        if(A == null) { return B; }
        if(B == null) { return A; }

        var C = new BinaryTree(A.value + B.value);

        C.left = mergeBinaryTrees(A.left, B.left);
        C.right = mergeBinaryTrees(A.right, B.right);

        return C;
    }
}
