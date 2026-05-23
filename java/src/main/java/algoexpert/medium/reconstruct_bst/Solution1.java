package algoexpert.medium.reconstruct_bst;
import java.util.*;

// Approach: TODO.
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

    public BST reconstructBst(ArrayList<Integer> NLR) {
        var N = NLR.size();

        return reconstructBst(NLR, 0, N - 1);
    }

    private static BST reconstructBst(ArrayList<Integer> NLR, int lo, int hi) {
        var N = NLR.size();

        if(hi < lo || N <= hi) { return null; }
        
        var node = new BST(NLR.get(lo));

        int mid = lo + 1;
        while(mid < N && NLR.get(mid) < NLR.get(lo)) { mid++; }

        node.left = reconstructBst(NLR, lo + 1, mid - 1);
        node.right = reconstructBst(NLR, mid, hi);

        return node;
    }
}
