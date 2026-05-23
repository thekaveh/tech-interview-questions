package algoexpert.easy.evaluate_expression_tree;
import java.util.*;

// Approach: Recursive post-order evaluation.
class Solution1 {
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

        var btLeft = evaluateExpressionTree(tree.left);
        var btRight = evaluateExpressionTree(tree.right);

        if(tree.value == -1) { return btLeft + btRight; }
        if(tree.value == -2) { return btLeft - btRight; }
        if(tree.value == -3) { return btLeft / btRight; }
        if(tree.value == -4) { return btLeft * btRight; }

        return -1;
    }
}
