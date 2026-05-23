package algoexpert.medium.bst_construction;
import java.util.*;

// Approach: TODO.
class Solution1 {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int key) {
            insert(this, key);
            
            return this;
        }
        
        private static void insert(BST tree, int key) {
            if(tree == null) { return; }
            
            int cmp = Integer.valueOf(key).compareTo(tree.value);
            
            if (cmp < 0) {
                if(tree.left != null) 	{ insert(tree.left, key); }
                else 				    { tree.left = new BST(key); }
            }
            else if	(0 <= cmp) {
                if(tree.right != null) 	{ insert(tree.right, key); }
                else 					{ tree.right = new BST(key);; }
            }
        }

        public boolean contains(int key) {
            return contains(this, key);
        }
            
        private static boolean contains(BST tree, int key) {
            if(tree == null) { return false; }
            
            int cmp = Integer.valueOf(key).compareTo(tree.value);
            
            if      (cmp < 0)   { return contains(tree.left, key); }
            else if	(0 < cmp)	{ return contains(tree.right, key); }
            else 				{ return true; }
        }

        public BST remove(int key) {
            remove(this, null, key);
            
            return this;
        }

        private static void remove(BST tree, BST parent, int key) {
            int cmp = Integer.valueOf(key).compareTo(tree.value);
            
            if		(cmp < 0)   { if(tree.left != null)  { remove(tree.left, tree, key); } }
            else if	(0 < cmp)	{ if(tree.right != null) { remove(tree.right, tree, key); } }
            else {
                if(tree.left != null && tree.right != null) {
                    tree.value = tree.right.min();
                    remove(tree.right, tree, tree.value);
                }
                else if(parent == null) {
                    if(tree.left != null) {
                        tree.value = tree.left.value;
                        tree.right = tree.left.right;
                        tree.left = tree.left.left;
                    }
                    else if(tree.right != null) {
                        tree.value = tree.right.value;
                        tree.left = tree.right.left;
                        tree.right = tree.right.right;
                    }
                }
                else if(parent.left == tree) {
                    parent.left = (tree.left != null) ? tree.left : tree.right;
                }
                else {
                    parent.right = (tree.left != null) ? tree.left : tree.right;
                }
            }
        }
        
        public int min() {
            BST current = this;
            
            while(current.left != null) { current = current.left; }
            
            return current.value;
        }
    }
}
