package algoexpert.medium.cycle_in_graph;
import java.util.*;

// Approach: TODO.
class Solution4 {
    public boolean cycleInGraph(int[][] edges) {
        return new DFS(new Graph(edges)).hasCycle();
    }

    static class Graph {
        private Map<Integer, List<Integer>> adj;

        public Graph(int[][] E) {
            this.adj = new HashMap<Integer, List<Integer>>();
            
            int N = E.length;
            for(var i = 0;i < N; i++) {
                this.adj.put(i, new ArrayList<Integer>());
                    
                for(var e : E[i]) { this.adj.get(i).add(e); }
            }
        }

        public Iterable<Integer> V() 		{ return this.adj.keySet(); }
        public Iterable<Integer> adj(int v) { return this.adj.get(v); }
    }

    static class DFS {
        private boolean hasCycle = false;
        
        public boolean hasCycle() { return this.hasCycle; }
        
        public DFS(Graph G) {
            var M = new HashMap<Integer, Boolean>();
            var T = new HashMap<Integer, Boolean>();
            
            for(var v : G.V()) { M.put(v, false); T.put(v, false); }
            
            for(var v : G.V()) {
                if(M.get(v)) { continue; }
                
                if(hasCycle(v, G, M, T)) { this.hasCycle = true; break; }
            }
        }
        
        private static boolean hasCycle(int v, Graph G, Map<Integer, Boolean> M, Map<Integer, Boolean> T) {
            M.put(v, true);
            T.put(v, true);
            
            for(var w : G.adj(v)) {
                if(!M.get(w))   { if(hasCycle(w, G, M, T)) { return true; } }
                if(T.get(w))    { return true; }
            }
            
            T.put(v, false);
            
            return false;
        }
    }
}
