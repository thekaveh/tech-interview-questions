import java.util.*;

class Solution2 {
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
        var S = new Stack<Integer>();

        traverseRNL(tree, k, S);

        return S.pop();
    }

    private static void traverseRNL(BST tree, int k, Stack<Integer> S) {
        if(tree == null || S.size() == k) { return; }

        traverseRNL(tree.right, k, S);

        if(S.size() < k) { S.push(tree.value); }

        traverseRNL(tree.left, k, S);
    }
}