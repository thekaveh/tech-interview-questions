import java.util.*;

class Solution3 {
    // Do not edit the class below except for the
    // populateSuffixTrieFrom and contains methods.
    // Feel free to add new properties and methods
    // to the class.
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        static char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String key) {
            for(int i = 0; i < key.length(); i++) {
                    insert(root, key.substring(i), 0);
                }
        }
            
        private static void insert(TrieNode node, String key, int at) {
            int N = key.length();
            
            if(node == null || at > N) { return; }
            
            char keyChar = (at < N) ? key.charAt(at) : endSymbol;
            
            if(!node.children.containsKey(keyChar)) {
                node.children.put(keyChar, (keyChar != endSymbol) ? new TrieNode() : null);
            }
            
            insert(node.children.get(keyChar), key, at + 1);
        }

        public boolean contains(String key) {
            return contains(root, key, 0);
        }
            
        private static boolean contains(TrieNode node, String key, int at) {
            int N = key.length();
            
            if(node == null || at > N) { return false; }
            else {
                char keyChar = (at < N) ? key.charAt(at) : endSymbol;
                
                if(!node.children.containsKey(keyChar)) { return false; }
                
                return (at == N)
                    ? node.children.containsKey('*')
                    : contains(node.children.get(keyChar), key, at + 1);
            }
        }
    }
}