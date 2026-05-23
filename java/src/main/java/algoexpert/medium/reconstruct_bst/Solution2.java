package algoexpert.medium.reconstruct_bst;
import java.util.*;

// Approach: Recursive using subList slicing.
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

    public BST reconstructBst(List<Integer> NLR) {
		var N = NLR.size();
		
		if(N == 0) { return null; }
		
		var v = NLR.get(0);
		var node = new BST(v);

		var mid = 1;
		while(mid < N && NLR.get(mid) < v) { mid++; }
		
		node.left = reconstructBst(NLR.subList(1, mid));
		node.right = reconstructBst(NLR.subList(mid, N));
        
        return node;
    }
}
