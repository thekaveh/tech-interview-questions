import java.util.*;

class Solution4 {
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

    public static int nodeDepths(BinaryTree root) {
        int R = 0;
        var S = new Stack<Map.Entry<BinaryTree, Integer>>();
        
        S.push(new AbstractMap.SimpleEntry<>(root, 0));
        
        while(!S.isEmpty()) {
            var next = S.pop();
            
            R += next.getValue();
            
            for(var child : new BinaryTree[] { next.getKey().left, next.getKey().right }) {
                if(child != null) {
                    S.push(new AbstractMap.SimpleEntry<>(child, next.getValue() + 1));
                }
            }
        }
        
        return R;
    }
}