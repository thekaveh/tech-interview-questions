import java.util.*;

class Solution1 {
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        var S = new Stack<Integer>();
        var R = new ArrayList<Integer>();

        solve(root, S, R);

        return R;
    }

    private static void solve(BinaryTree node, Stack<Integer> S, List<Integer> R) {
        if(node == null) { return; }

        S.push(node.value);

        if(node.left == null && node.right == null) {
            var sum = 0;

            for(var val : S) { sum += val; }

            R.add(sum);
        }

        solve(node.left, S, R);
        solve(node.right, S, R);

        S.pop();
    }
}