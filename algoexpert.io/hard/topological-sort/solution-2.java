import java.util.*;

class Program {
    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
        return new Topological(new Graph(jobs, deps)).order();
    }
	
	static class Graph {
		private Map<Integer, List<Integer>> adj;
		
		public Graph(List<Integer> V, List<Integer[]> E) {
			this.adj = new HashMap<Integer, List<Integer>>();
			
			for(var v : V) { this.adj.put(v, new ArrayList<Integer>()); }
			for(var e : E) { this.adj.get(e[0]).add(e[1]); }
		}
		
		public Iterable<Integer> V() 		{ return this.adj.keySet(); }
		public Iterable<Integer> adj(int v) { return this.adj.get(v); }
	}
	
	static class Topological {
		private List<Integer> O;
		
		public Topological(Graph G) {
			this.O = new ArrayList<Integer>();
			
			var M = new HashMap<Integer, Boolean>();
			var R = new HashMap<Integer, Boolean>();
			
			for(var v : G.V()) { M.put(v, false); R.put(v, false); }
			
			for(var v : G.V()) {
				if(M.get(v)) { continue; }
				
				if(!dfs(v, G, M, R, this.O)) { break; }
			}
		}
		
		private static boolean dfs(int v, Graph G, Map<Integer, Boolean> M, Map<Integer, Boolean> R, List<Integer> O) {
			M.put(v, true);
			R.put(v, true);
			
			for(var w : G.adj(v)) {
				if			(!M.get(w))	{ if(!dfs(w, G, M, R, O)) { O.clear(); return false; } }
				else if	(R.get(w))	{ return false; }
			}
			
			O.add(0, v);
			R.put(v, false);
			
			return true;
		}
		
		List<Integer> order() { return this.O; }
	}
}