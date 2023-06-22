import java.util.*;

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