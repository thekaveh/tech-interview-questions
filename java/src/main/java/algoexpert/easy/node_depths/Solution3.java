package algoexpert.easy.node_depths;
import java.util.*;

// Approach: Iterative DFS, custom Pair node+depth.
class Solution3 {
    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    static class Pair<K, V> {
        private final K key;
        private final V value;
        
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
        public K getKey() {
            return this.key;
        }
        
        public V getValue() {
            return this.value;
        }
    }

    public static int nodeDepths(BinaryTree root) {
        int R = 0;
        var S = new Stack<Pair<BinaryTree, Integer>>();
        
        S.push(new Pair<BinaryTree, Integer>(root, 0));
        
        while(!S.isEmpty()) {
            var next = S.pop();
            
            R += next.getValue();
            
            for(var child : new BinaryTree[] { next.getKey().left, next.getKey().right }) {
                if(child != null) {
                    S.push(new Pair<>(child, next.getValue() + 1));
                }
            }
        }
        
        return R;
    }
}
