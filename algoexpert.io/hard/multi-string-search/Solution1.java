import java.util.*;

class Solution1 {
    public static List<Boolean> multiStringSearch(String txt, String[] keys) {
        var M = new SuffixTrie(txt);
        var R = new ArrayList<Boolean>();

        for (var key : keys) { R.add(M.has(key)); }

        return R;
    }

    static class SuffixTrie {
        static class Node {
            Map<Character, Node> children = new HashMap<Character, Node>();
        }

        final Node root = new Node();

        SuffixTrie(String txt) {
            var N = txt.length();

            for (var at = 0; at < N; at++) { put(txt.substring(at)); }
        }

        void put(String key) {
            var x = this.root;

            for (var c : key.toCharArray()) {
                if (!x.children.containsKey(c)) {
                    x.children.put(c, new Node());
                }

                x = x.children.get(c);
            }
        }

        boolean has(String key) {
            var x = this.root;

            for (var c : key.toCharArray()) {
                if (!x.children.containsKey(c)) { return false; }

                x = x.children.get(c);
            }

            return true;
        }
    }
}