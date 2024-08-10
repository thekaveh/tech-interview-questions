import java.util.*;

class Solution1 {
	public static List<String> boggleBoard(char[][] board, String[] words) {
		int R = board.length, C = board[0].length;
		var T = new Trie();
		var X = new HashSet<String>();
		var M = new boolean[R][C];

		for (var word : words) {
			T.add(word);
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (canVisitDFS(r, c, T.root, board, M)) {
					visitDFS(r, c, T.root, board, M, X);
				}
			}
		}

		return new ArrayList<String>(X);
	}

	private static void visitDFS(int r, int c, Trie.Node trieNode, char[][] board, boolean[][] M,
			Set<String> X) {
		M[r][c] = true;

		trieNode = trieNode.children.get(board[r][c]);

		if (trieNode.children.containsKey(Trie.END_SYMBOL)) {
			X.add(trieNode.key);
		}

		for (var adj : adj(r, c)) {
			if (!canVisitDFS(adj[0], adj[1], trieNode, board, M)) {
				continue;
			}

			visitDFS(adj[0], adj[1], trieNode, board, M, X);
		}

		M[r][c] = false;
	}

	private static boolean canVisitDFS(int r, int c, Trie.Node trieNode, char[][] board, boolean[][] M) {
		int R = board.length, C = board[0].length;

		if (r < 0 || R <= r) {
			return false;
		}
		if (c < 0 || C <= c) {
			return false;
		}
		if (M[r][c]) {
			return false;
		}
		if (!trieNode.children.containsKey(board[r][c])) {
			return false;
		}

		return true;
	}

	private static int[][] adj(int r, int c) {
		return new int[][] {
				{ r - 1, c - 1 }, { r - 1, c }, { r - 1, c + 1 }, { r, c - 1 },
				{ r, c + 1 }, { r + 1, c - 1 }, { r + 1, c }, { r + 1, c + 1 }
		};
	}

	static class Trie {
		Node root;
		static final char END_SYMBOL = '*';

		Trie() {
			this.root = new Node();
		}

		void add(String key) {
			var x = root;

			for (var c : key.toCharArray()) {
				x.children.putIfAbsent(c, new Node());
				x = x.children.get(c);
			}

			x.key = key;
			x.children.put(END_SYMBOL, null);
		}

		static class Node {
			String key;
			Map<Character, Node> children = new HashMap<Character, Node>();
		}
	}
}