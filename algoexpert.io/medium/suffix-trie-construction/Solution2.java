import java.util.*;

class Solution2 {
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

        public void populateSuffixTrieFrom(String key) {
            var N = key.length();

            for(var i = 0; i < N; i++) {
                insert(key.substring(i));
            }
        }

        private void insert(String key) {
            var N = key.length();

            var node = root;
            for(var at = 0; at < N; at++) {
                var c = key.charAt(at);

                if(!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }

                node = node.children.get(c);
            }

            node.children.put(endSymbol, null);
        }

        public boolean contains(String key) {
            var N = key.length();

            var node = root;
            for(var at = 0; at < N; at++) {
                var c = key.charAt(at);

                if(!node.children.containsKey(c)) { return false; }

                node = node.children.get(c);
            }

            return node.children.containsKey(endSymbol);
        }
    }
}