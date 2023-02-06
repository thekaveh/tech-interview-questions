import java.util.*;

class Program {
    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
        return new Topological(jobs, deps).order();
    }

    static class Topological {
        List<Integer> order;

        Topological(List<Integer> V, List<Integer[]> E) {
            var O = new ArrayList<Integer>();
            var M = new HashMap<Integer, Boolean>();
            var R = new HashMap<Integer, Boolean>();

            for(var v : V) { M.put(v, false); R.put(v, false); }

            for(var v : V) {
                if(M.get(v)) { continue; }

                if(!dfs(v, V, E, M, R, O)) { break; }
            }
            
            this.order = O.size() == V.size() ? O : new ArrayList<>();
        }

        private static boolean dfs(int v, List<Integer> V, List<Integer[]> E, Map<Integer, Boolean> M, Map<Integer, Boolean> R, ArrayList<Integer> O) {
            M.put(v, true);
            R.put(v, true);

            for(var e : E) {
                if(e[0] != v) { continue; }
                var w = e[1];

                if  (!M.get(w)) { if(!dfs(w, V, E, M, R, O)) { return false; } }
                if  (R.get(w))  { return false; }
            }

            O.add(0, v);
            R.put(v, false);

            return true;
        }
        
        List<Integer> order()   { return this.order; }
    }
}