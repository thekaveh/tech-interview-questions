package algoexpert.easy.run_length_encoding;
import java.util.*;

// Approach: do-while loop, inner while extends run.
class Solution3 {
    public String runLengthEncoding(String input) {
        var i = 0;
        var N = input.length();
        var R = new StringBuilder();

        do {
            var runCount = 1;
            var runChar = input.charAt(i);
            
            while(i + 1 < N && runChar == input.charAt(i + 1) && runCount < 9) {
                i++;
                runCount++;
            }
            
            R.append(runCount);
            R.append(runChar);
            
            i++;		
        } while(i < N);

        return R.toString();
    }
}
