package algoexpert.medium.cycle_in_graph;
import java.util.*;

// Approach: DFS with Graph class using adjacency HashMap.
class Solution3 {
    static class Graph {
        int V;
        Map<Integer, List<Integer>> adj;
        
        public Graph(int[][] E) {
            this.V = E.length;
            this.adj = new HashMap<>();
            
            for(int v = 0; v < V; v++) {
                this.adj.put(v, new LinkedList<>());
                
                for(var w : E[v]) { this.adj.get(v).add(w); }
            }
        }
        
        int V() 					{ return this.V; }
        List<Integer> adj(int v) 	{ return this.adj.get(v); }
    }

    static class DFS {
        boolean hasCycle = false;
        
        boolean hasCycle() { return this.hasCycle; }
        
        public DFS(Graph G) {
            var M = new HashMap<Integer, Boolean>();
            var R = new HashMap<Integer, Boolean>();
            
            for(var v = 0; v < G.V(); v++) { M.put(v, false); R.put(v, false); }
            
            for(var v = 0; v < G.V(); v++) {
                if(M.get(v)) { continue; }
                
                if(!visit(v, G, M, R)) { this.hasCycle = true; break; }
            }
        }
        
        private boolean visit(int v, Graph G, Map<Integer, Boolean> M, Map<Integer, Boolean> R) {
            M.put(v, true);
            R.put(v, true);
            
            for(var w : G.adj(v)) {
                if(!M.get(w))   { if(!visit(w, G, M, R)) { return false; } }
                if(R.get(w))    { return false; }
            }
            
            R.put(v, false);
            
            return true;
        }
    }

    public boolean cycleInGraph(int[][] E) {
        var G = new Graph(E);
        
        return new DFS(G).hasCycle();
    }
}
