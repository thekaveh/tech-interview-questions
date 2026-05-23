package algoexpert.medium.suffix_trie_construction;
import java.util.*;

// Approach: Iterative insertion and lookup.
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

            for (var i = 0; i < N; i++) {
                insert(key.substring(i));
            }
        }

        private void insert(String key) {
            var N = key.length();

            var x = root;
            for (var at = 0; at < N; at++) {
                var c = key.charAt(at);

                if (!x.children.containsKey(c)) {
                    x.children.put(c, new TrieNode());
                }

                x = x.children.get(c);
            }

            x.children.put(endSymbol, null);
        }

        public boolean contains(String key) {
            var N = key.length();

            var x = root;
            for (var at = 0; at < N; at++) {
                var c = key.charAt(at);

                if (!x.children.containsKey(c)) {
                    return false;
                }

                x = x.children.get(c);
            }

            return x.children.containsKey(endSymbol);
        }
    }
}
