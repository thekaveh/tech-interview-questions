import java.util.*;

class Solution1 {
	public String[] shortestUniquePrefixes(String[] keys) {
		int N = keys.length;
		Trie trie = new Trie();

		for (String key : keys) {
			trie.put(key);
		}

		var prefixes = new String[N];
		for (int i = 0; i < N; i++) {
			prefixes[i] = uniquePrefixOf(keys[i], trie);
		}

		return prefixes;
	}

	private static String uniquePrefixOf(String key, Trie trie) {
		var x = trie.root;
		var prefix = new StringBuilder();

		for (char c : key.toCharArray()) {
			prefix.append(c);
			x = x.children.get(c);

			if (x.size == 1) {
				return prefix.toString();
			}
		}

		return key;
	}

	static class Trie {
		Node root;

		public Trie() {
			this.root = new Node();
		}

		public void put(String key) {
			var x = this.root;

			for (char c : key.toCharArray()) {
				x.size++;
				x.children.putIfAbsent(c, new Node());
				x = x.children.get(c);
			}

			x.size++;
		}

		static class Node {
			int size;
			Map<Character, Node> children;

			public Node() {
				this.size = 0;
				this.children = new HashMap<>();
			}
		}
	}
}
