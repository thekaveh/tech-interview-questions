import java.util.*;

class Program {
    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        if(node.right != null) {
            var cur = node.right;
            while(cur.left != null) { cur = cur.left; }

            return cur;
        }
        else {
            var cur = node;
            while(cur.parent != null && cur.parent.right == cur) { cur = cur.parent; }

            return cur.parent;
        }
    }
}