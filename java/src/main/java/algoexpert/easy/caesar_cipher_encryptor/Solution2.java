package algoexpert.easy.caesar_cipher_encryptor;
import java.util.*;

// Approach: Arithmetic modulo 26, char cast.
class Solution2 {
    public static String caesarCypherEncryptor(String plain, int k) {
        var R = new StringBuilder();

        for(var c : plain.toCharArray()) {
            var fromIdx = c - 'a';
            var toIdx = (fromIdx + k) % ('z' - 'a' + 1);

            R.append((char)('a' + toIdx));
        }

        return R.toString();
    }
}
