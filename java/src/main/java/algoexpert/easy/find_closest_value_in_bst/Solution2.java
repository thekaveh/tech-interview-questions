package algoexpert.easy.find_closest_value_in_bst;
import java.util.*;
import javax.lang.model.util.ElementScanner6;

// Approach: TODO.
class Solution2 {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static int findClosestValueInBst(BST tree, int v) {
        var C = tree;
        var t = tree.value;

        while(C != null) {
            if(Math.abs(v - C.value) < Math.abs(v - t)) { t = C.value; }

            if      (v < C.value)   { C = C.left; }
            else if (C.value < v)   { C = C.right; }
            else                    { break; }
        }

        return t;
    }
}
