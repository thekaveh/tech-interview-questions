import java.util.*;

class Program {
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

        return solve(A, 0, N - 1);
    }

    private static BST solve(List<Integer> A, int lo, int hi) {
        if(lo > hi) { return null; }

        var mid = lo + (hi - lo) / 2;

        var tree = new BST(A.get(mid));
        
        tree.left = solve(A, lo, mid - 1);
        tree.right = solve(A, mid + 1, hi);

        return tree;
    }
}