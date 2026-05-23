package algoexpert.hard.repair_bst;
import java.util.*;

// Approach: In-order traversal to detect two out-of-order nodes + value swap.
class Solution1 {
    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    private BST nodeOne = null, nodeTwo = null, prevNode = null;

    public BST repairBst(BST tree) {
        inOrder(tree);

        var t = this.nodeOne.value;
        this.nodeOne.value = this.nodeTwo.value;
        this.nodeTwo.value = t;

        return tree;
    }

    private void inOrder(BST node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);

        if (this.prevNode != null && this.prevNode.value > node.value) {
            if (this.nodeOne == null) {
                this.nodeOne = this.prevNode;
            }
            this.nodeTwo = node;
        }

        this.prevNode = node;

        inOrder(node.right);
    }
}
