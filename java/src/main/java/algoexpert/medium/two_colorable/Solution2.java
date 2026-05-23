package algoexpert.medium.two_colorable;
import java.util.*;

// Approach: Iterative DFS graph coloring with stack.
class Solution2 {
    public boolean twoColorable(int[][] E) {
        var V = E.length;
        var C = new Boolean[V];
        var S = new Stack<Integer>();

        S.push(0);
        C[0] = false;

        while (!S.isEmpty()) {
            var v = S.pop();

            for (var w : E[v]) {
                if (C[w] == null) {
                    S.push(w);
                    C[w] = !C[v];
                } else if (C[v] == C[w]) {
                    return false;
                }
            }
        }

        return true;
    }
}
