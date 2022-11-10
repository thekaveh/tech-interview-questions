import java.util.*;

class Program {
    public String runLengthEncoding(String txt) {
        var N = txt.length();
        var cipher = new StringBuilder();

        for(var lo = 0; lo < N; lo++) {
            var runCount = 1;
            var runChar = txt.charAt(lo);

            for(var hi = lo + 1; hi < N && runChar == txt.charAt(hi) && runCount < 9; hi++) {
                lo++;
                runCount++;
            }

            cipher.append(runCount);
            cipher.append(runChar);
        }

        return cipher.toString();
    }
}