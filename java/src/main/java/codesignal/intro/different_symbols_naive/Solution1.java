package codesignal.intro.different_symbols_naive;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: HashSet accumulation.
class Solution1 {
    static int solution(String txt) {
        var M = new HashSet<Character>();

        for(var c : txt.toCharArray()) { M.add(c); }

        return M.size();
    }
}
