package algoexpert.easy.node_depths;
import java.util.*;

// Approach: BFS level-order, accumulate depth per level.
class Solution1 {
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
		int D = 0, R = 0;
		var Q = new LinkedList<BinaryTree>();
	
		Q.offer(root);
	
		while(!Q.isEmpty()) {
			for(var L = Q.size(); 0 < L; L--) {
				var v = Q.poll();
	
				R += D;
	
				for(var w : new BinaryTree[] { v.left, v.right }) {
					if(w == null) { continue; }
					
					Q.offer(w);
				}
			}
			
			D++;
		}
		
		return R;
    }
}
