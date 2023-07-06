import java.util.*;

// Do not edit the class below except for
// the constructor and the createSet, find,
// and union methods. Feel free to add new
// properties and methods to the class.
class Solution1 {
    static class UnionFind {
        private Map<Integer, Integer> parents;

        UnionFind() { this.parents = new HashMap<>(); }

        // T: O(1) | S: O(1)
        public void createSet(int v) {
            if(this.parents.containsKey(v)) { return; }

            this.parents.put(v, v);
        }

        // T: O(N) | S: O(1)
        public Integer find(int v) {
            if(!this.parents.containsKey(v)) { return null; }

            var x = v; for(; x != this.parents.get(x); x = this.parents.get(x));

            return x;
        }

        // T: O(N) | S: O(1)
        public void union(int v, int w) {
            if(!this.parents.containsKey(v) || !this.parents.containsKey(w)) { return; }

            var vRoot = find(v);
            var wRoot = find(w);

            this.parents.put(wRoot, vRoot);
        }
    }
}