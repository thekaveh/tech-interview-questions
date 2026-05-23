package algoexpert.medium.union_find;
import java.util.*;

// Approach: Union by size (weighted union) with HashMap.
// Do not edit the class below except for
// the constructor and the createSet, find,
// and union methods. Feel free to add new
// properties and methods to the class.
class Solution2 {
    static class UnionFind {
        private Map<Integer, Integer> sizes;
        private Map<Integer, Integer> parents;

        UnionFind() {
            this.sizes = new HashMap<>();
            this.parents = new HashMap<>();
        }

        // T: O(1) | S: O(1)
        public void createSet(int v) {
            if(this.parents.containsKey(v)) { return; }

            this.sizes.put(v, 1);
            this.parents.put(v, v);
        }

        // T: O(log(N)) | S: O(1)
        public Integer find(int v) {
            if(!this.parents.containsKey(v)) { return null; }

            var x = v; for(; x != this.parents.get(x); x = this.parents.get(x));

            return x;
        }

        // T: O(log(N)) | S: O(1)
        public void union(int v, int w) {
            if(!this.parents.containsKey(v) || !this.parents.containsKey(w)) { return; }

            var vRoot = find(v);
            var vSize = this.sizes.get(v);

            var wRoot = find(w);
            var wSize = this.sizes.get(w);

            if(vSize < wSize) {
                this.parents.put(vRoot, wRoot);
                this.sizes.put(wRoot, vSize + wSize);
            }
            else {
                this.parents.put(wRoot, vRoot);
                this.sizes.put(vRoot, vSize + wSize);
            }
        }
    }
}
