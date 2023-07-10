import java.util.*;

class Solution1 {
    public boolean twoColorable(int[][] E) {
        var V = E.length;
        var C = new Boolean[V];

        for (var v = 0; v < V; v++) {
            if (C[v] != null) {
                continue;
            }

            if (!visit(v, E, C, false)) {
                return false;
            }
        }

        return true;
    }

    private static boolean visit(int v, int[][] E, Boolean[] C, boolean c) {
        C[v] = c;

        for (var w : E[v]) {
            if (C[w] == null) {
                if (!visit(w, E, C, !c)) {
                    return false;
                }
            } else if (C[v] == C[w]) {
                return false;
            }
        }

        return true;
    }
}