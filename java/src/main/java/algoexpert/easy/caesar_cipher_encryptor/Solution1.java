package algoexpert.easy.caesar_cipher_encryptor;
import java.util.*;

// Approach: Alphabet string indexOf lookup.
class Solution1 {
    private static final String R = "abcdefghijklmnopqrstuvwxyz";

    public static String caesarCypherEncryptor(String plain, int k) {
        var cipher = new StringBuilder();

        for(char c : plain.toCharArray()) {
            var fromIdx = R.indexOf(c);
            var toIdx = (fromIdx + k) % R.length();

            cipher.append(R.charAt(toIdx));
        }

        return cipher.toString();
    }
}
