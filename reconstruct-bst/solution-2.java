import java.util.*;

class Program {
    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public BST reconstructBst(ArrayList<Integer> NLR) {
        return reconstruct(NLR);
    }

    public BST reconstruct(List<Integer> NLR) {
        var N = NLR.size();

        if(N == 0) { return null; }

        var v = NLR.get(0);
        var node = new BST(v);

        var idx = 1;
        while(idx < N && NLR.get(idx) < v) { idx++; }

        node.left = reconstruct(NLR.subList(1, idx));
        node.right = reconstruct(NLR.subList(idx, N));

        return node;
    }
}