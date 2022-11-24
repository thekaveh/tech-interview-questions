import java.util.*;

class Program {
    // Do not edit the class below except for the
    // populateSuffixTrieFrom and contains methods.
    // Feel free to add new properties and methods
    // to the class.
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String S) {
            populateSuffixTrieFrom(S);
        }

        public void populateSuffixTrieFrom(String S) {
            var N = S.length();

            for(var i = 0; i < N; i++) {
                this.root = put(this.root, S.substring(i), 0);
            }
        }

        private static TrieNode put(TrieNode node, String S, int d) {
            if(node == null) { node = new TrieNode(); }

            var N = S.length();

            var key = (d < N) ? S.charAt(d) : '*';
            var val = (d < N) ? put(node.children.get(key), S, d + 1) : null;

            node.children.put(key, val);

            return node;
        }

        public boolean contains(String S) {
            return has(this.root, S, 0);
        }

        private static boolean has(TrieNode node, String S, int d) {
            if(node == null) { return false; }

            var N = S.length();

            var key = (d < N) ? S.charAt(d) : '*';

            if(!node.children.containsKey(key)) { return false; }

            if(d < N)   { return has(node.children.get(key), S, d + 1); }
            else        { return true; }
        }
    }
}