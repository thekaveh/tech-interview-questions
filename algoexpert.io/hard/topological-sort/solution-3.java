import java.util.*;

class Program {
    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
        var G = new Graph(jobs);
        
        for(var dep : deps) { G.addEdge(dep[0], dep[1]); }
        
        return new Topological(G).order();
    }
	
	static class Graph {
		Map<Integer, List<Integer>> adj;
		
		Graph(List<Integer> vertices) {
			this.adj = new HashMap<Integer, List<Integer>>();
			
			for(var v : vertices) { this.adj.put(v, new ArrayList<Integer>()); }
		}
		
		void addEdge(int v, int w) 		{ this.adj.get(v).add(w); }
		Iterable<Integer> adj(int v) 	{ return this.adj.get(v); }
		Iterable<Integer> vertices() 	{ return this.adj.keySet(); }
	}
	
	static class Topological {
		Graph g;
		boolean hasCycle;
		List<Integer> order;
		
		Topological(Graph g) {
			this.g = g;
			this.order = new ArrayList<Integer>();
			
			var visited = new HashMap<Integer, Boolean>();
			for(var v : g.vertices()) { visited.put(v, false); }
			
			var runningPath = new ArrayList<Integer>();
			
			for(var v : g.vertices()) {
				if(visited.get(v)) { continue; }
				
				dfs(v, runningPath, visited);
			}
		}
		
		private void dfs(int v, List<Integer> runningPath, Map<Integer, Boolean> visited) {
			if(this.hasCycle) { return; }
			
			visited.put(v, true);
			runningPath.add(0, v);
			
			for(var w : this.g.adj(v)) {
				if(runningPath.contains(w)) { this.hasCycle = true; }
				if(visited.get(w)) 			{ continue; }
				
				dfs(w, runningPath, visited);
			}
			
			this.order.add(0, v);
			runningPath.remove(0);
		}
		
		List<Integer> order() { return !this.hasCycle ? this.order : new ArrayList<Integer>(); }
	}
}