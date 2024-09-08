import java.util.*;

class Solution1 {
	public String longestMostFrequentPrefix(String[] keys) {
		int N = keys.length;
		Trie trie = new Trie();

		for (String key : keys) {
			trie.put(key);
		}

		return trie.maxPrefix;
	}

	static class Trie {
		Node root;

		int maxPrefixCount = 0;
		String maxPrefix = "";

		public Trie() {
			this.root = new Node();
		}

		public void put(String key) {
			var x = this.root;
			x.count++;

			for (var at = 0; at < key.length(); at++) {
				var c = key.charAt(at);

				x.children.putIfAbsent(c, new Node());
				x = x.children.get(c);
				x.count++;

				if (this.maxPrefixCount < x.count) {
					this.maxPrefixCount = x.count;
					this.maxPrefix = key.substring(0, at + 1);
				} else if (this.maxPrefixCount == x.count && this.maxPrefix.length() < at + 1) {
					this.maxPrefix = key.substring(0, at + 1);
				}
			}
		}

		static class Node {
			int count;
			Map<Character, Node> children;

			public Node() {
				this.count = 0;
				this.children = new HashMap<>();
			}
		}
	}
}