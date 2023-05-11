import java.util.*;

class Program {
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
        if(A == null && B == null) { return null; }

        var a = A != null ? A.value : 0;
        var b = B != null ? B.value : 0;

        var C = new BinaryTree(a + b);

        C.left = mergeBinaryTrees(A != null ? A.left : null, B != null ? B.left : null);
        C.right = mergeBinaryTrees(A != null ? A.right : null, B != null ? B.right : null);

        return C;
    }
}