import java.util.*;

class Solution1 {
    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public boolean symmetricalTree(BinaryTree tree) {
        var Q = new LinkedList<BinaryTree>();

        Q.offer(tree);

        while (!Q.isEmpty()) {
            var L = Q.size();

            for (int lo = 0, hi = L - 1; lo <= hi; lo++, hi--) {
                var loBt = Q.get(lo);
                var hiBt = Q.get(hi);

                if (loBt == null && hiBt == null)   { continue; }
                if (loBt == null || hiBt == null)   { return false; }
                if (loBt.value != hiBt.value)       { return false; }
            }

            for (var i = 0; i < L; i++) {
                var v = Q.poll();

                if (v == null) { continue; }

                for (var w : new BinaryTree[] { v.left, v.right }) { Q.offer(w); }
            }
        }

        return true;
    }
}