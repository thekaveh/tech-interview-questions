package algoexpert.medium.bst_construction;
import java.util.*;

// Approach: Iterative insert / contains / remove.
class Solution2 {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int key) {
            BST current = this;
                
            while(current != null) {
                int cmp = Integer.valueOf(key).compareTo(current.value);
                
                if (cmp < 0)    {
                    if(current.left != null)    { current = current.left; }
                    else                        { current.left = new BST(key); break; }
                }
                else if (0 <= cmp)  {
                    if(current.right != null)   { current = current.right; }
                    else                        { current.right = new BST(key); break; }
                }
            }
                
            return this;
        }

        public boolean contains(int key) {
            BST current = this;
            
            while(current != null) {
                int cmp = Integer.valueOf(key).compareTo(current.value);
                
                if      (cmp < 0)   { current = current.left; }
                else if (0 < cmp)   { current = current.right; }
                else                { return true; }
            }
                
            return false;
        }

        public BST remove(int key) {
            remove(this, null, key);
            
            return this;
        }

        public void remove(BST node, BST parent, int key) {
            BST current = node;
            
            while(current != null) {
                int cmp = Integer.valueOf(key).compareTo(current.value);
                
                if      (cmp < 0)   { parent = current; current = current.left; }
                else if (0 < cmp)   { parent = current; current = current.right; }
                else                            {
                    if(current.left != null && current.right != null) {
                        current.value = current.right.min();
                        remove(current.right, current, current.value);
                    }
                    else if(parent == null) {
                        if(current.left != null) {
                            current.value = current.left.value;
                            current.right = current.left.right;
                            current.left = current.left.left;
                        }
                        else if(current.right != null) {
                            current.value = current.right.value;
                            current.left = current.right.left;
                            current.right = current.right.right;
                        }
                    }
                    else if(parent.left == current) {
                        parent.left = (current.left != null) ? current.left : current.right;
                    }
                    else {
                        parent.right = (current.left != null) ? current.left : current.right;
                    }
                    
                    break;
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
