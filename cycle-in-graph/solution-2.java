import java.util.*;

class Program {
    static class Graph {
        private int[][] E;

        public Graph(int[][] E) { this.E = E; }
        int V() 				{ return this.E.length; }
        int[] adj(int v)		{ return this.E[v]; }
    }
  
    static class DFS {
        boolean hasCycle = false;

        boolean hasCycle() { return this.hasCycle; }

        public DFS(Graph G) {
            var M = new boolean[G.V()];
            var R = new boolean[G.V()];
            
            for(var v = 0; v < G.V(); v++) {
                if(M[v]) { continue; }
                
                if(!visit(v, G, M, R)) { this.hasCycle = true; break; }
            }
        }

        private boolean visit(int v, Graph G, boolean[] M, boolean[] R) {
            M[v] = true;
            R[v] = true;
            
            for(var w : G.adj(v)) {
                if     (!M[w]) { if(!visit(w, G, M, R)) { return false; } }
                else if(R[w])  { return false; }
            }
            
            R[v] = false;
            
            return true;
        }
    }
	
    public boolean cycleInGraph(int[][] E) {
        var G = new Graph(E);
        
        return new DFS(G).hasCycle();
    }
}