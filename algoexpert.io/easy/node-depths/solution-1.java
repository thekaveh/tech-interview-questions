import java.util.*;

class Program {
    static class BinaryTree {
            int value;
            BinaryTree left;
            BinaryTree right;

            public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static int nodeDepths(BinaryTree root) {
        int R = 0, D = 0, L = 0;
        Queue<BinaryTree> Q = new LinkedList<>();

        Q.offer(root);

        while(!Q.isEmpty()) {
            L = Q.size();

            for(var i = 0; i < L; i++) {
                var node = Q.poll();

                R += D;

                for(var child : new BinaryTree[] { node.left, node.right }) {
                    if(child != null) { Q.offer(child); }
                }
            }

            D++;
        }

        return R;
    }
}