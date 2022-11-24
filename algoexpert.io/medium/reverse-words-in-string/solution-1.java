import java.util.*;

class Program {
    public String reverseWordsInString(String text) {
        var N = text.length();
        var lo = 0;
        var R = new StringBuilder(text);

        reverse(R, 0, N - 1);

        while(lo < N) {
            var hi = lo;
            while(hi < N && R.charAt(hi) != ' ') { hi++; }

            reverse(R, lo, hi - 1);

            lo = hi;
            while(lo < N && R.charAt(lo) == ' ') { lo++; }
        }

        return R.toString();
    }

    private static void reverse(StringBuilder text, int lo, int hi) {
        while(lo < hi) {
            var t = text.charAt(lo);
            text.setCharAt(lo, text.charAt(hi));
            text.setCharAt(hi, t);

            lo++;
            hi--;
        }
    }
}