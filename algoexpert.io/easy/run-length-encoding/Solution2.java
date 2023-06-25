import java.util.*;

class Solution2 {
    public String runLengthEncoding(String txt) {
        var N = txt.length();
        var R = new StringBuilder();

        for(var lo = 0; lo < N; lo++) {
            var runLen = 1;
            var runChar = txt.charAt(lo);

            for(var hi = lo + 1; hi < N && txt.charAt(hi) == runChar && runLen < 9; hi++) {
                lo++;
                runLen++;
            }

            R.append(runLen);
            R.append(runChar);
        }

        return R.toString();
    }
}