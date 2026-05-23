package codesignal.intro.sum_up_numbers;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Split on non-digits, filter, parse, reduce.
class Solution2 {
    static int solution(String txt) {
        return Arrays.stream(txt.split("\\D+"))
                     .filter(s -> !s.isEmpty())
                     .map(s -> Integer.valueOf(s))
                     .reduce(0, (a, b) -> a + b);
    }
}
