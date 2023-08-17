import java.util.*;

class Program {
    public static BinaryTree rightSiblingTree(BinaryTree root) {
        var nil = new BinaryTree(-1);
        var Q = new LinkedList<BinaryTree>();

        Q.offer(root);

        while (!Q.isEmpty()) {
            var L = Q.size();

            for (var i = 0; i < L; i++) {
                var v = Q.poll();

                if (v == nil) { continue; }

                var lt = (v.left != null) ? v.left : nil;
                var rt = (v.right != null) ? v.right : nil;

                if (i < L - 1 && Q.peek() != nil)   { v.right = Q.peek(); }
                else                                { v.right = null; }

                Q.offer(lt);
                Q.offer(rt);
            }
        }

        return root;
    }

    // This is the class of the input root. Do not edit it.
    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}