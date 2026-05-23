package algoexpert.medium.cycle_in_graph;
import java.util.*;

// Approach: DFS with boolean visited + recursion-stack arrays.
class Solution5 {
    public boolean cycleInGraph(int[][] E) {
        var N = E.length;

        var M = new boolean[N];
        var R = new boolean[N];

        for (var v = 0; v < N; v++) {
            if (M[v]) {
                continue;
            }
            if (dfs(E, v, M, R)) {
                return true;
            }
        }

        return false;
    }

    private static boolean dfs(int[][] E, int v, boolean[] M, boolean[] R) {
        M[v] = true;
        R[v] = true;

        for (var w : E[v]) {
            if (M[w]) {
                if (R[w]) {
                    return true;
                }
            } else {
                if (dfs(E, w, M, R)) {
                    return true;
                }
            }
        }

        R[v] = false;

        return false;
    }
}
