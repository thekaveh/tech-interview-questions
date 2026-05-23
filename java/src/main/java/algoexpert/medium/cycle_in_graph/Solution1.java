package algoexpert.medium.cycle_in_graph;
import java.util.*;

// Approach: TODO.
class Solution1 {
    public boolean cycleInGraph(int[][] E) {
        return new DFS(E).hasCycle();
    }

    static class DFS {
        private boolean hasCycle = false;

        public boolean hasCycle() { return this.hasCycle; }

        public DFS(int[][] E) {
            var M = new HashMap<Integer, Boolean>();
            var R = new HashMap<Integer, Boolean>();

            for(var v = 0; v < E.length; v++) { M.put(v, false); R.put(v, false); }

            for(var v = 0; v < E.length; v++) {
                if(M.get(v)) { continue; }

                if(hasCycle(v, E, M, R)) { this.hasCycle = true; break; }
            }
        }

        private static boolean hasCycle(int v, int[][] E, Map<Integer, Boolean> M, Map<Integer, Boolean> R) {
            M.put(v, true);
            R.put(v, true);

            for(var w : E[v]) {
                if(M.get(w))    { if(R.get(w))              { return true; } }
                else            { if(hasCycle(w, E, M, R))  { return true; } }
            }

            R.put(v, false);

            return false;
        }
    }
}
