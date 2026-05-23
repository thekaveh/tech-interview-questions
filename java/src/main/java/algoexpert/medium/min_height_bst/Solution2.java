package algoexpert.medium.min_height_bst;
import java.util.*;

// Approach: Divide and conquer using subList slicing.
class Solution2 {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                }
                else {
                    left.insert(value);
                }
            }
            else {
                if (right == null) {
                    right = new BST(value);
                }
                else {
                    right.insert(value);
                }
            }
        }
    }

    public static BST minHeightBst(List<Integer> A) {
        var N = A.size();

        if(N == 0) { return null; }

        var mid = N / 2;

        var tree = new BST(A.get(mid));
        
        tree.left = minHeightBst(A.subList(0, mid));
        tree.right = minHeightBst(A.subList(mid + 1, N));

        return tree;
    }
}
