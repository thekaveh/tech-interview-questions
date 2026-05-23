package algoexpert.medium.height_balanced_binary_tree;
import java.util.*;

// Approach: TODO.
class Solution3 {
    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        return solve(tree).getValue();
    }

    private static Map.Entry<Integer, Boolean> solve(BinaryTree tree) {
        if(tree == null) { return new AbstractMap.SimpleEntry<>(0, true); }
    
        var lt = solve(tree.left);
        var rt = solve(tree.right);
    
        var height = Math.max(lt.getKey(), rt.getKey()) + 1;
        var balanced = lt.getValue() && rt.getValue() && Math.abs(lt.getKey() - rt.getKey()) <= 1;
    
        return new AbstractMap.SimpleEntry<>(height, balanced);
    }
}
