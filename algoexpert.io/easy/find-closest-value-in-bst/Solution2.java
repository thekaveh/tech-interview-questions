import java.util.*;

import javax.lang.model.util.ElementScanner6;

class Solution2 {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static int findClosestValueInBst(BST tree, int target) {
        var C = tree;
        var R = tree.value;

        while(C != null) {
            if(Math.abs(target - C.value) < Math.abs(target - R)) { R = C.value; }

            if      (target < C.value)  { C = C.left; }
            else if (C.value < target)  { C = C.right; }
            else                        { break; }
        }

        return R;
    }
}