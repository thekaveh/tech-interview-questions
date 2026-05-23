package codesignal.intro.alphabetic_shift;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Single pass with modular arithmetic.
class Solution1 {
    static String solution(String txt) {
        var R = new StringBuilder();
        
        for(var from : txt.toCharArray()) {
            var to = (char)((from - 'a' + 1) % ('z' - 'a' + 1) + 'a');
            
            R.append(to);
        }
        
        return R.toString();
    }
}
