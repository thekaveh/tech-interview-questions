import java.util.*;

class Program {
    public String reverseWordsInString(String text) {
        var N = text.length();
        var R = new StringBuilder(text);

        reverse(R, 0, N - 1);

        for(var lo = 0; lo < N; lo++) {
            if(R.charAt(lo) == ' ') { continue; }

            var hi = lo;
            while(hi < N && R.charAt(hi) != ' ') { hi++; };

            reverse(R, lo, hi - 1);

            lo = hi;
        }

        return R.toString();
    }

    private static void reverse(StringBuilder text, int lo, int hi) {
        for(; lo < hi; lo++, hi--) {
            var loChar = text.charAt(lo);
            var hiChar = text.charAt(hi);

            text.setCharAt(lo, hiChar);
            text.setCharAt(hi, loChar);
        }
    }
}