package algoexpert.medium.invert_binary_tree;
import java.util.*;

// Approach: TODO.
class Solution2 {
    public static void invertBinaryTree(BinaryTree tree) {
        Queue<BinaryTree> Q = new LinkedList<>();

        Q.offer(tree);

        while(!Q.isEmpty()) {
            var next = Q.poll();

            var T = next.left;
            next.left = next.right;
            next.right = T;

            for(var child : new BinaryTree[] { next.left, next.right }) {
                if(child != null) { Q.offer(child); }
            }
        }
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
