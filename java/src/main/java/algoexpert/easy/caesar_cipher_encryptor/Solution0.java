package algoexpert.easy.caesar_cipher_encryptor;
import java.util.*;

// Approach: TODO.
class Solution0 {
	public static String caesarCypherEncryptor(String txt, int k) {
		var R = new StringBuilder();

		for(var c : txt.toCharArray()) {
			var delta = (c - 'a' + k) % ('z' - 'a' + 1);
			
			R.append((char)('a' + delta));
		}

		return R.toString();
	}
}
