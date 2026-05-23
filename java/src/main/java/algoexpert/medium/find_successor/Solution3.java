package algoexpert.medium.find_successor;
import java.util.*;

// Approach: TODO.
class Solution3 {
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

        traverseRNL(tree, node, S);

        while(!S.isEmpty()) {
            if(S.pop() == node) {
                if(!S.isEmpty())    { return S.peek(); }
                else                { return null; }
            }
        }

        return null;
    }

    private static void traverseRNL(BinaryTree tree, BinaryTree node, Stack<BinaryTree> S) {
        if(tree == null) { return; }
        
        traverseRNL(tree.right, node, S);

        S.push(tree); if(tree == node) { return; }

        traverseRNL(tree.left, node, S);
    }
}
