import java.util.*;

class Program {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public int evaluateExpressionTree(BinaryTree tree) {
        if(tree == null) { return 0; }

        if(tree.left == null && tree.right == null) { return tree.value; }

        if(tree.value == -1) { return evaluateExpressionTree(tree.left) + evaluateExpressionTree(tree.right); }
        if(tree.value == -2) { return evaluateExpressionTree(tree.left) - evaluateExpressionTree(tree.right); }
        if(tree.value == -3) { return evaluateExpressionTree(tree.left) / evaluateExpressionTree(tree.right); }
        if(tree.value == -4) { return evaluateExpressionTree(tree.left) * evaluateExpressionTree(tree.right); }

        return -1;
    }
}