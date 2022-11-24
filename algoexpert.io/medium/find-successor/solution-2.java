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
        var S = new Stack<BinaryTree>();

        traverseRNL(tree, S);

        while(!S.isEmpty()) {
            if(S.pop() == node) {
                if(!S.isEmpty())    { return S.peek(); }
                else                { return null; }
            }
        }

        return null;
    }

    private static void traverseRNL(BinaryTree node, Stack<BinaryTree> S) {
        if(node == null) { return; }
        
        traverseRNL(node.right, S);

        S.push(node);

        traverseRNL(node.left, S);
    }
}