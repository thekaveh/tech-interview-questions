package algoexpert.medium.youngest_common_ancestor;
import java.util.*;

// Approach: TODO.
class Solution1 {
    public static AncestralTree getYoungestCommonAncestor(AncestralTree R, AncestralTree A, AncestralTree B) {
        int dA = 0, dB = 0;
        for(var x = A; x != R; x = x.ancestor) { dA++; }
        for(var x = B; x != R; x = x.ancestor) { dB++; }

        if     (dA < dB) { while(dA != dB) { B = B.ancestor; dB--; } }
        else if(dB < dA) { while(dA != dB) { A = A.ancestor; dA--; } }

        while(A != B) { A = A.ancestor; B = B.ancestor; }

        return A;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
				descendant.ancestor = this;
            }
        }
    }
}
