import java.util.*;

class Program {
    public static AncestralTree getYoungestCommonAncestor(AncestralTree R, AncestralTree A, AncestralTree B) {
        int depthA = 0, depthB = 0;
        for(var T = A; T != R; T = T.ancestor) { depthA++; }
        for(var T = B; T != R; T = T.ancestor) { depthB++; }

        if     (depthA > depthB)    { for(; depthA > depthB; depthA--) { A = A.ancestor; } }
        else if(depthB > depthA)    { for(; depthB > depthA; depthB--) { B = B.ancestor; } }

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