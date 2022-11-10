import java.util.*;

class Program {
    public String runLengthEncoding(String txt) {
        var N = txt.length();
        var cipher = new StringBuilder();

        for(var i = 0; i < N; i++) {
            var runCount = 1;
            var runChar = txt.charAt(i);
            
            while(i + 1 < N && runChar == txt.charAt(i + 1) && runCount < 9) {
                i++;
                runCount++;
            }

            cipher.append(runCount);
            cipher.append(runChar);
        }

        return cipher.toString();
    }
}