import java.util.*;

class Program {
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